package org.cook.rpc.helix.transfer;

import org.cook.rpc.helix.model.rpc.RPCHeader;
import org.cook.rpc.helix.model.rpc.RPCMessage;
import org.cook.rpc.helix.utils.H;

import java.util.concurrent.Future;

public class NettyRPCClient implements RPCClient {

    @Override
    public Future send(RPCChannel channel, RPCMessage message) {
        RPCHeader header = message.getHeader();
        byte[] data = message.encode();

        header.setBodyLength(data.length);

        channel.write(H.toBytes(header));
        Future future = channel.writeAndFlush(data);

        return future;
    }
}
