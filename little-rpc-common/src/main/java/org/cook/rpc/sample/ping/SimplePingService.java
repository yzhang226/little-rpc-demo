package org.cook.rpc.sample.ping;

import com.google.protobuf.Int32Value;
import org.cook.rpc.helix.model.protobuf.PBHeartbeatModel;
import org.cook.rpc.helix.transfer.RPCService;

//@RPCService
public class SimplePingService  {// implements ISimplePingService

    @RPCService
    public Int32Value ping(PBHeartbeatModel input) {
        // TODO:
        System.out.println(" input " + input.getBeat());
        return Int32Value.of(input.getBeat() + 1);
    }

    @RPCService
    public long ping2(long val) {
        System.out.println(" input " + 4444);
        return 0;
    }

    public static void main(String[] args) {
        SimplePingService pingService = new SimplePingService();
        pingService.ping(PBHeartbeatModel.newBuilder().setBeat(3333).build());
    }

}
