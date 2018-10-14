package org.cook.rpc;

import org.cook.rpc.helix.model.protobuf.PBHeartbeatModel;
import org.cook.rpc.helix.model.rpc.ProtoBufRequest;
import org.cook.rpc.sample.ping.SimplePingService;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        SimplePingService pingService = new SimplePingService();
        pingService.ping(new ProtoBufRequest<>(PBHeartbeatModel.newBuilder().setBeat(3333).build()));
    }

}
