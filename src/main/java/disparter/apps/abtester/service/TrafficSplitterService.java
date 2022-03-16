package disparter.apps.abtester.service;

import disparter.apps.abtester.controller.in.TrafficChannel;
import disparter.apps.abtester.controller.in.TrafficSplitOptions;
import org.springframework.stereotype.Service;

@Service
public class TrafficSplitterService {

    public TrafficChannel split(TrafficSplitOptions options, String value) {
        setupSplitOptions(options);
        return chooseChannel(value);
    }

    private TrafficChannel chooseChannel(String value) {
        //todo
        return null;
    }

    private void setupSplitOptions(TrafficSplitOptions options) {
        validateRangeProperlySetup(options);
        //todo
    }

    private void validateRangeProperlySetup(TrafficSplitOptions options) {
        var total = 100;
        for(var option:options.getChannelList()){
            total -= option.getTrafficAllocation();
        }
        if(total != 0){
            throw new IllegalArgumentException("The total traffic allocation should be 100");
        }
    }
}
