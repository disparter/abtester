package disparter.apps.abtester.controller.out;

import disparter.apps.abtester.controller.in.TrafficChannel;
import lombok.Data;

@Data
public class TrafficSplitResult {
    TrafficChannel channel;
}
