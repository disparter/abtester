package disparter.apps.abtester.controller;

import disparter.apps.abtester.controller.in.TrafficSplitOptions;
import disparter.apps.abtester.controller.out.TrafficSplitResult;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Controller;

@Controller("abtest")
public class TrafficSplitterController {

    public TrafficSplitResult split(TrafficSplitOptions options, JSONObject payload){
        return null;
    }

}
