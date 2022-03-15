package disparter.apps.abtester.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisProperties {

    @Getter int redisPort;
    @Getter String redisHost;

    public RedisProperties(
      @Value("${spring.redis.port}") int redisPort,
      @Value("${spring.redis.host}") String redisHost) {
        this.redisPort = redisPort;
        this.redisHost = redisHost;
    }

}