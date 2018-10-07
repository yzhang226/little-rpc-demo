package org.cook.rpc.sample.seri;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Handler implementation for the object echo client.  It initiates the
 * ping-pong traffic between the object echo client and server by sending the
 * first message to the server.
 */
public class ObjectEchoClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(ObjectEchoClientHandler.class);

    private final List<Integer> firstMessage;

    private int count;

    /**
     * Creates a client-side handler.
     */
    public ObjectEchoClientHandler() {
        firstMessage = new ArrayList<Integer>(ObjectEchoClient.SIZE);
        for (int i = 0; i < ObjectEchoClient.SIZE; i++) {
            firstMessage.add(Integer.valueOf(i));
        }
        logger.info("new ObjectEchoClientHandler is {}", this);
    }

    private List<Integer> createMessage() {
        List<Integer> firstMessage = new ArrayList<Integer>(ObjectEchoClient.SIZE);
        for (int i = 0; i < max(); i++) {
            firstMessage.add(Integer.valueOf(i));
        }
        return firstMessage;
    }

    public int max() {
        return ObjectEchoClient.SIZE - count;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        logger.info("channelActive - handler is {}", this);
        // Send the first message if this handler is a client-side handler.
        ctx.writeAndFlush(createMessage());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        count++;
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
