package org.cook.rpc.helix;

import lombok.Getter;
import lombok.Setter;
import org.cook.rpc.helix.model.rpc.RPCRequest;

@Getter
@Setter
public class RpcRequest {

    private long requestId;

    private long methodMetaId;

    private long bodyLength;

    private RPCRequest parameter;



}
