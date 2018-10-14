package org.cook.rpc.sample.ping;

import com.google.protobuf.Int32Value;
import org.cook.rpc.helix.model.protobuf.PBHeartbeatModel;
import org.cook.rpc.helix.model.rpc.ProtoBufRequest;
import org.cook.rpc.helix.model.rpc.ProtoBufResponse;
import org.cook.rpc.helix.model.rpc.RPCRequest;
import org.cook.rpc.helix.model.rpc.RPCResponse;
import org.cook.rpc.helix.transfer.RPCService;

//@RPCService
public class SimplePingService  {// implements ISimplePingService

    @RPCService
    public RPCResponse<Int32Value> ping(RPCRequest<PBHeartbeatModel> input) {
        // TODO:
        System.out.println(" input " + input.getParameter().getBeat());
        return ProtoBufResponse.wrap(Int32Value.of(input.getParameter().getBeat() + 1));
    }

    @RPCService
    public long ping2(long val) {
        System.out.println(" input " + 4444);
        return 0;
    }

    public static void main(String[] args) {
        SimplePingService pingService = new SimplePingService();
        pingService.ping(new ProtoBufRequest<>(PBHeartbeatModel.newBuilder().setBeat(3333).build()));
    }

}
