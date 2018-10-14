package org.cook.rpc.sample.ping;

import com.google.protobuf.Int32Value;
import org.cook.rpc.helix.model.protobuf.PBHeartbeatModel;
import org.cook.rpc.helix.model.rpc.RPCResponse;
import org.cook.rpc.helix.transfer.RPCService;


public interface ISimplePingService {

    RPCResponse<Int32Value> ping(PBHeartbeatModel input);

    long ping2(long val);

}
