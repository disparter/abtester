package disparter.apps.abtester.controller.out;

import disparter.apps.abtester.controller.in.TrafficChannel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrafficSplitResult {
    TrafficChannel channel;
}
