package disparter.apps.abtester.controller;

import disparter.apps.abtester.controller.in.TrafficChannel;
import disparter.apps.abtester.controller.in.TrafficSplitOptions;
import disparter.apps.abtester.controller.out.TrafficSplitResult;
import disparter.apps.abtester.service.TrafficSplitterService;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller("abtest")
public class TrafficSplitterController {

    private final TrafficSplitterService service;

    public TrafficSplitterController(TrafficSplitterService service){
        this.service = service;
    }

    public TrafficSplitResult split(TrafficSplitOptions options, String value){
        Optional<TrafficChannel> chosenChannel = service.split(options, value);
        var result = new TrafficSplitResult();
        result.setChannel(chosenChannel.orElseThrow());
        return result;
    }

}
