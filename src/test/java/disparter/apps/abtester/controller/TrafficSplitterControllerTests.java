package disparter.apps.abtester.controller;

import disparter.apps.abtester.controller.in.TrafficSplitOptions;
import disparter.apps.abtester.controller.out.TrafficSplitResult;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TrafficSplitterControllerTests {

	TrafficSplitterController controller;

	@BeforeEach
	public void setup(){
		controller = new TrafficSplitterController();
	}

	@Test
	public void test_splitOn() {
		TrafficSplitResult expected = new TrafficSplitResult();
		JSONObject payload = null;
		var options = new TrafficSplitOptions();
		var result = controller.split(options, payload);
		Assertions.assertEquals(expected, result);
	}

}
