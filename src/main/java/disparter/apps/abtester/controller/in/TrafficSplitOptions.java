package disparter.apps.abtester.controller.in;

import lombok.Data;

import java.util.List;

@Data
public class TrafficSplitOptions {
    List<TrafficChannel> channelList;
    String value;
}
