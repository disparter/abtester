package disparter.apps.abtester.service;

import disparter.apps.abtester.config.TestRedisConfiguration;
import disparter.apps.abtester.controller.in.TrafficSplitOptions;
import disparter.apps.abtester.controller.out.TrafficSplitResult;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestRedisConfiguration.class)
class TrafficSplitterServiceTests {

	TrafficSplitterService service;

	@BeforeEach
	public void setup(){
		service = new TrafficSplitterService();
	}

	@Test
	public void test_splitOn() {
		TrafficSplitResult expected = new TrafficSplitResult();
		JSONObject payload = null;
		var options = new TrafficSplitOptions();
		var result = service.split(options, payload);
		Assertions.assertEquals(expected, result);
	}

}
