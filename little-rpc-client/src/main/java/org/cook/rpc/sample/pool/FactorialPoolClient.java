package org.cook.rpc.sample.pool;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import org.cook.rpc.sample.factorial.FactorialClientHandler;

import java.net.InetSocketAddress;

/**
 * Created by cook on 2018/10/4
 */
public class FactorialPoolClient {

    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        final Bootstrap cb = new Bootstrap();
        cb.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2000);
        InetSocketAddress addr1 = new InetSocketAddress("127.0.0.1", 8322);
        InetSocketAddress addr2 = new InetSocketAddress("127.0.0.1", 8323);

        cb.group(group).channel(NioSocketChannel.class);

        FixedChannelFactory channelFactory = new FixedChannelFactory(cb, 8, 8);

        // depending on when you use addr1 or addr2 you will get different pools.
        InetSocketAddress selected = addr1;
        Future<Channel> f = channelFactory.acquire(selected);
        f.addListener(new FutureListener<Channel>() {
            @Override
            public void operationComplete(Future<Channel> f) {
                if (f.isSuccess()) {
                    Channel ch = f.getNow();
                    // Do somethings
                    ChannelFuture lastWriteFuture = null;
                    try {
//                        lastWriteFuture = ch.writeAndFlush(10);

                        FactorialClientHandler handler =
                                (FactorialClientHandler) ch.pipeline().last();

                        System.out.println("Factorial result is " + handler.getFactorial());

                        // Wait until all messages are flushed before closing the channel.
//                        if (lastWriteFuture != null) {
//                            lastWriteFuture.sync();
//                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        // Release back to pool
                        channelFactory.release(selected, ch);
                    }

                }
            }
        });

//        try {
//            Thread.sleep(2 * 60 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

}
