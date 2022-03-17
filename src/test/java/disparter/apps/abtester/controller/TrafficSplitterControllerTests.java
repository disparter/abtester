package disparter.apps.abtester.controller;

import disparter.apps.abtester.config.TestRedisConfiguration;
import disparter.apps.abtester.controller.in.TrafficSplitOptions;
import disparter.apps.abtester.controller.out.TrafficSplitResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestRedisConfiguration.class)
public class TrafficSplitterControllerTests {

    @LocalServerPort
    private int port;

    @Test
    public void testTrafficSplit() {
        TestRestTemplate restTemplate = new TestRestTemplate();
        var options = new TrafficSplitOptions();
        HttpEntity<TrafficSplitOptions> requestEntity = new HttpEntity<TrafficSplitOptions>(options, new HttpHeaders());

        ResponseEntity<TrafficSplitResult> response = restTemplate.exchange(
                createURLWithPort("/abtest"), HttpMethod.POST, requestEntity, TrafficSplitResult.class);

        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}