package org.cook.rpc.sample.pool;

import com.google.common.collect.Lists;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.pool2.impl.DefaultEvictionPolicy;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cook on 2018/10/7
 */
public class CommonsPoolClient {

    private static final Logger logger = LoggerFactory.getLogger(CommonsPoolClient.class);

    private static final ExecutorService executor = Executors.newFixedThreadPool(8);

    public static void main(String[] args) {
        SimpleHost host1 = new SimpleHost("127.0.0.1", 8322);
        SimpleHost host2 = new SimpleHost("127.0.0.1", 8323);

        PooledChannelFactory factory = new PooledChannelFactory(Lists.newArrayList(host1, host2), new MyChannelPoolHandler());

        GenericObjectPoolConfig<Channel> conf = new GenericObjectPoolConfig<>();
        conf.setMaxTotal(6);
        conf.setMaxIdle(4);
        conf.setMinIdle(2);

        conf.setMaxWaitMillis(5 * 1000);
        conf.setTestWhileIdle(true);
        conf.setTestOnBorrow(true);
        conf.setTimeBetweenEvictionRunsMillis(15 * 1000);

        GenericObjectPool<Channel> pool = new GenericObjectPool<>(factory, conf);

        for (int i=0; i<20; i++) {
            // Do somethings
            executor.execute(() -> {
                doSomethings(pool);
            });
        }

        try {
            Thread.sleep(2 * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pool.close();

        factory.shutdown();

    }

    private static void doSomethings(GenericObjectPool<Channel> pool) {
        Channel ch = null;
        ChannelFuture lastWriteFuture = null;
        try {
            ch = pool.borrowObject();
            lastWriteFuture = ch.writeAndFlush(RandomUtils.nextInt(20, 100));
//                 Wait until all messages are flushed before closing the channel.
            if (lastWriteFuture != null) {
                lastWriteFuture.sync();
            }
        } catch (Exception e) {
            logger.error("", e);
        } finally {
            try {
                if (null != ch) {
                    pool.returnObject(ch);
                }
            } catch (Exception e) {
                logger.error("return channel error", e);
            }
        }
    }

}
