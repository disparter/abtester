package disparter.apps.abtester.controller.out;

import disparter.apps.abtester.controller.in.TrafficChannel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrafficSplitResult {
    TrafficChannel channel;
}
