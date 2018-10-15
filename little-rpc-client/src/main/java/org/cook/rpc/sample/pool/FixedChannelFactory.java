package org.cook.rpc.sample.pool;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.pool.AbstractChannelPoolMap;
import io.netty.channel.pool.FixedChannelPool;
import io.netty.util.concurrent.Future;
import org.cook.rpc.pool.MyChannelPoolHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.ExecutionException;

/**
 * Created by cook on 2018/10/4
 */
public class FixedChannelFactory extends AbstractChannelPoolMap<InetSocketAddress, FixedChannelPool> {

    private static final Logger logger = LoggerFactory.getLogger(FixedChannelFactory.class);

    private Bootstrap cb;

    private int maxConns;

    private int maxPendings;

    public FixedChannelFactory(Bootstrap cb, int maxConns, int maxPendings) {
        this.cb = cb;
        this.maxConns = maxConns;
        this.maxPendings = maxPendings;
    }

    @Override
    protected FixedChannelPool newPool(InetSocketAddress key) {
        return new FixedChannelPool(cb.remoteAddress(key), new MyChannelPoolHandler(), maxConns, maxPendings);
    }

    public Future<Channel> acquire(InetSocketAddress addr) {
        final FixedChannelPool pool = this.get(addr);
        Future<Channel> f = pool.acquire();
        f.getNow();
        try {
            Channel ch = f.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return f;
    }

    public void release(InetSocketAddress addr, Channel ch) {
        SocketAddress address = ch.localAddress();
//        logger.info("ch.localAddress() is {}, addr is {}", ch.localAddress(), addr);
        final FixedChannelPool pool = this.get(addr);
        pool.release(ch);
    }

}
