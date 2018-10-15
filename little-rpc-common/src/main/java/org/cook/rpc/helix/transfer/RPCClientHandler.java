package org.cook.rpc.helix.transfer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class RPCClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(RPCClientHandler.class);

    public RPCClientHandler() {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        logger.info("channelActive - handler is {}", this);
        // Send the first message if this handler is a client-side handler.
        ctx.writeAndFlush(createMessage());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // Echo back the received object to the server.
        logger.info("client receive msg is {}", msg);
        if (count < 5) {
            ctx.write(createMessage());
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
