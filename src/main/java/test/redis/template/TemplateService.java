package test.redis.template;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import test.redis.User;

@Service
@RequiredArgsConstructor
public class TemplateService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void saveUser(User user) {
        redisTemplate.opsForValue().set("template:" + user.getId(), user);
    }

    public User getUser(String id) {
        return (User) redisTemplate.opsForValue().get("template:" + id);
    }

    public void deleteUser(String id) {
        redisTemplate.delete("template:" + id);
    }
}
