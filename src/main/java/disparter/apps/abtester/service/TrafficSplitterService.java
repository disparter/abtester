package disparter.apps.abtester.service;

import disparter.apps.abtester.controller.in.TrafficChannel;
import disparter.apps.abtester.controller.in.TrafficSplitOptions;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class TrafficSplitterService {

    public TrafficChannel split(TrafficSplitOptions options, JSONObject payload) {
        return null;
    }
}
