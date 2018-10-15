package org.cook.rpc.helix.transfer;

import io.netty.channel.Channel;

import java.util.concurrent.Future;

public class NettyChannel implements RPCChannel {

    private Channel ch;

    public NettyChannel(Channel ch) {
        this.ch = ch;
    }

    public static NettyChannel of(Channel ch) {
        return new NettyChannel(ch);
    }

    @Override
    public Future write(byte[] data) {
        return ch.write(data);
    }

    @Override
    public void flush() {
        ch.flush();
    }

    @Override
    public Future writeAndFlush(byte[] data) {
        return ch.writeAndFlush(data);
    }
}
