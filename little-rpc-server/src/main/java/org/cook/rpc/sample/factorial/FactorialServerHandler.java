package org.cook.rpc.sample.factorial;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

/**
 * Handler for a server-side channel.  This handler maintains stateful
 * information which is specific to a certain channel using member variables.
 * Therefore, an instance of this handler can cover only one channel.  You have
 * to create a new handler instance whenever you create a new channel and insert
 * this handler  to avoid a race condition.
 */
public class FactorialServerHandler extends SimpleChannelInboundHandler<BigInteger> {

    private static final Logger logger = LoggerFactory.getLogger(FactorialServerHandler.class);

//    private BigInteger lastMultiplier = new BigInteger("1");
//    private BigInteger factorial = new BigInteger("1");

    public FactorialServerHandler() {
        logger.info("new FactorialServerHandler is {}", this);
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, BigInteger msg) throws Exception {
        long s1 = System.currentTimeMillis();
        // Calculate the cumulative factorial and send it to the client.
        logger.info("server received msg is {}", msg);
//        BigInteger lastMultiplier = new BigInteger("1");
        BigInteger factorial = new BigInteger("1");

        for (long i=1; i<=msg.longValue(); i++) {
//            lastMultiplier = msg;
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        logger.info("server received msg is {}, factorial is {}, elapsed {} ms", msg, factorial, System.currentTimeMillis() - s1);

        ctx.writeAndFlush(factorial);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        System.err.printf("Factorial of %,d is: %,d%n", lastMultiplier, factorial);
        logger.info("channelInactive this is {}, ctx is {}", this, ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

