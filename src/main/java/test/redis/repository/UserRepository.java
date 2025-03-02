package test.redis.repository;


import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import test.redis.User;

public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByName(String name);
}
