package test.redis;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("user")
@Getter
@AllArgsConstructor
public class User implements Serializable {
    @Id
    private String id;
    @Indexed
    private String name;
}
