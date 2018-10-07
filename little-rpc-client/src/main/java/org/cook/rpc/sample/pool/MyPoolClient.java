package org.cook.rpc.sample.pool;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import org.apache.commons.lang3.RandomUtils;
import org.cook.rpc.sample.factorial.FactorialClientHandler;
import org.cook.rpc.sample.seri.ObjectEchoClientHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * Created by cook on 2018/10/4
 */
public class MyPoolClient {

    private static final Logger logger = LoggerFactory.getLogger(MyPoolClient.class);

    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        final Bootstrap cb = new Bootstrap();
//        cb.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2000);
//        cb.option(ChannelOption.SO_KEEPALIVE, true);
//        cb.option(ChannelOption.SO_BACKLOG, 128);

        InetSocketAddress addr1 = new InetSocketAddress("127.0.0.1", 8322);// 8322 8007
        InetSocketAddress addr2 = new InetSocketAddress("127.0.0.1", 8323);

        cb.group(group).channel(NioSocketChannel.class);

        FixedChannelFactory channelFactory = new FixedChannelFactory(cb, 4, 8);

        // depending on when you use addr1 or addr2 you will get different pools.
        for (int i=0; i<10; i++) {
            InetSocketAddress selected = addr1;
            Future<Channel> channelFuture = channelFactory.acquire(selected);
            MyFutureListener listener = new MyFutureListener(channelFactory, selected);
            channelFuture.addListener(listener);

        }

        try {
            Thread.sleep(2 * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        group.shutdownGracefully();

    }

    public static class MyFutureListener implements FutureListener<Channel> {

        private FixedChannelFactory channelFactory;
        private InetSocketAddress selected;

        public MyFutureListener(FixedChannelFactory channelFactory, InetSocketAddress selected) {
            this.channelFactory = channelFactory;
            this.selected = selected;
        }

        @Override
        public void operationComplete(Future<Channel> f) throws Exception {
            if (f.isSuccess()) {
                Channel ch = f.getNow();
                // Do somethings
                ChannelFuture lastWriteFuture = null;
                try {
                    lastWriteFuture = ch.writeAndFlush(RandomUtils.nextInt(20, 100));

//                    FactorialClientHandler handler =
//                            (FactorialClientHandler) ch.pipeline().last();
//                    logger.info("Factorial result is {}" + handler.getFactorial());

//                    ObjectEchoClientHandler handler =
//                            (ObjectEchoClientHandler) ch.pipeline().last();
//                    logger.info("ObjectEchoClientHandler max is {}", handler.max());

//                     Wait until all messages are flushed before closing the channel.
                    if (lastWriteFuture != null) {
                        lastWriteFuture.sync();
                    }
                } catch (Exception e) {
                    logger.error("", e);
                } finally {
                    // Release back to pool
                    channelFactory.release(selected, ch);
                }

            } else {
                logger.error("Channel of Future is {}", f);
            }
        }
    }

}
