package org.cook.rpc.sample.pool;

import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.pool.ChannelPoolHandler;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;
import org.cook.rpc.sample.common.BigIntegerDecoder;
import org.cook.rpc.sample.common.NumberEncoder;
import org.cook.rpc.sample.factorial.FactorialClientHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by cook on 2018/10/4
 */
public class MyChannelPoolHandler implements ChannelPoolHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyChannelPoolHandler.class);

    @Override
    public void channelReleased(Channel ch) throws Exception {
        logger.info("channelReleased ch is {}", ch);
    }

    @Override
    public void channelAcquired(Channel ch) throws Exception {
        logger.info("channelAcquired ch is {}", ch);
    }

    @Override
    public void channelCreated(Channel ch) throws Exception {
        logger.info("channelCreated ch is {}", ch);

//        SocketChannel channel = (SocketChannel) ch;
//        channel.con

        ChannelPipeline pipeline = ch.pipeline();

//        if (sslCtx != null) {
//            pipeline.addLast(sslCtx.newHandler(ch.alloc(), FactorialClient.HOST, FactorialClient.PORT));
//        }

        // Enable stream compression (you can remove these two if unnecessary)
        pipeline.addLast(ZlibCodecFactory.newZlibEncoder(ZlibWrapper.GZIP));
        pipeline.addLast(ZlibCodecFactory.newZlibDecoder(ZlibWrapper.GZIP));

        // Add the number codec first,
        pipeline.addLast(new BigIntegerDecoder());
        pipeline.addLast(new NumberEncoder());

        // and then business logic.
        pipeline.addLast(new FactorialClientHandler());

//        pipeline.addLast(
//                new ObjectEncoder(),
//                new ObjectDecoder(ClassResolvers.cacheDisabled(null)),
//                new ObjectEchoClientHandler());

    }
}
