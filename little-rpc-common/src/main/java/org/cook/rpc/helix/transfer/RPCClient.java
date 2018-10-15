package org.cook.rpc.helix.transfer;

import org.cook.rpc.helix.model.rpc.RPCMessage;

import java.util.concurrent.Future;

public interface RPCClient {

    /**
     *
     * @param channel
     * @param message
     * @return
     */
    Future send(RPCChannel channel, RPCMessage message);

}
