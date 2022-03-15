package disparter.apps.abtester;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled("redis server is not configured")
class AbtesterApplicationTests {

	@Test
	void contextLoads() {
	}

}
