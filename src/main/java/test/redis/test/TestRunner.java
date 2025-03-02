package test.redis.test;

import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import test.redis.User;
import test.redis.repository.UserRepository;
import test.redis.template.TemplateService;

@Component
@RequiredArgsConstructor
public class TestRunner implements CommandLineRunner {

    private final UserRepository repository;
    private final TemplateService template;
    private final JedisMonitorService monitorService;

    @Override
    public void run(String... args) throws Exception {
        monitorService.start();
        Thread.sleep(1000);

        String id = UUID.randomUUID().toString();
        System.out.println("\n 유저 id 값 : " + id);
        String name = "test";
        User user = new User(id, name);

        /**
         *  PING , CLIENT 는 저장과 상관 없는 명령어
         *  PING : 연결이 정상인지 체크
         *  CLIENT : 사용하는 라이브러리 , 클라이언트 버전 정보 전달
         */
        System.out.println("\n repository 저장 실행");
        repository.save(user);

        System.out.println("\n repository 조회 실행");
        Optional<User> result1 = repository.findById(id);
        result1.ifPresent(value -> System.out.println(("유저 id : "+value.getId() +" " + "유저 name : " + value.getName())));

        System.out.println("\n repository value 로 조회 실행");
        Optional<User> result2 = repository.findByName(name);
        result2.ifPresent(value -> System.out.println(("유저 id : "+value.getId()+ " " + "유저 name : " + value.getName())));

        System.out.println("\n repository 삭제 실행");
        repository.delete(user);

        System.out.println("\n template 저장 실행");
        template.saveUser(user);

        System.out.println("\n template 조회 실행");
        User result3 = template.getUser(id);
        System.out.println(("유저 id : "+result3.getId()+ " " + "유저 name : " + result3.getName()));

        System.out.println("\n template 삭제 실행");
        template.deleteUser(id);
    }
}
