package disparter.apps.abtester;

import disparter.apps.abtester.config.TestRedisConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestRedisConfiguration.class)
class AbtesterApplicationTests {

	@Test
	void contextLoads() {
	}

}
