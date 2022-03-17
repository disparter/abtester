package disparter.apps.abtester.controller;

import disparter.apps.abtester.controller.in.TrafficChannel;
import disparter.apps.abtester.controller.in.TrafficSplitOptions;
import disparter.apps.abtester.controller.out.TrafficSplitResult;
import disparter.apps.abtester.service.TrafficSplitterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("abtest")
public class TrafficSplitterController {

    private final TrafficSplitterService service;

    public TrafficSplitterController(TrafficSplitterService service){
        this.service = service;
    }

    @PostMapping("split")
    public ResponseEntity<TrafficSplitResult> split(TrafficSplitOptions options, String value){
        Optional<TrafficChannel> chosenChannel = service.split(options, value);
        return ResponseEntity.ok(TrafficSplitResult.builder()
                .channel(chosenChannel.orElseThrow())
                .build());
    }

}
