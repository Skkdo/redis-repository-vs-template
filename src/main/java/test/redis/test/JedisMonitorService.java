package test.redis.test;

import java.util.concurrent.Executors;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisMonitor;

@Service
public class JedisMonitorService {

    public void start() {
        Executors.newSingleThreadExecutor().submit(() -> {
            try (Jedis jedis = new Jedis("localhost", 6379)) {
                System.out.println("Redis Monitor 시작");
                jedis.monitor(new JedisMonitor() {
                    @Override
                    public void onCommand(String s) {
                        System.out.println("Command : " + s);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
