package disparter.apps.abtester.service;

import disparter.apps.abtester.controller.in.TrafficChannel;
import disparter.apps.abtester.controller.in.TrafficSplitOptions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrafficSplitterService {

    public Optional<TrafficChannel> split(TrafficSplitOptions options, String value) {
        var setup = setupSplitOptions(options);
        return chooseChannel(value, setup);
    }

    private Optional<TrafficChannel> chooseChannel(String value, List<Range> setup) {
        int checkNumber = calculateCheckNumber(value);
        return setup.stream().
                filter(r -> checkNumber < r.end && checkNumber >= r.start)
                .map(r -> r.channel)
                .findFirst();
    }

    private Integer calculateCheckNumber(String value){
        String hashCode = Integer.toString(value.hashCode());
        int result = 0;

        if(hashCode.length() > 1){
            result = Integer.parseInt(hashCode.substring(hashCode.length()-3, hashCode.length()-1));
        }else{
            result = Integer.parseInt(hashCode);
        }

        return  result;
    }

    private List<Range> setupSplitOptions(TrafficSplitOptions options) {
        validateRangeProperlySetup(options);
        var total = 100;
        List<Range> rangeList = new ArrayList<>();
        for(var option:options.getChannelList()){
            var end = total - option.getTrafficAllocation();
            rangeList.add(new Range(total, end, option));
            total = end;
        }
        return rangeList;
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

    @Getter
    @AllArgsConstructor
    public class Range{
        int start;
        int end;
        TrafficChannel channel;
    }
}
