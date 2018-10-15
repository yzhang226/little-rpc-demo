package org.cook.rpc.pool;

import com.google.common.collect.Lists;
import io.netty.channel.Channel;
import io.netty.channel.pool.ChannelPoolHandler;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ChannelPoolConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ChannelPoolConfiguration.class);

    private GenericObjectPool<Channel> pool;

    private List<SimpleHost> hosts;
    private ChannelPoolHandler poolHandler;

    public ChannelPoolConfiguration(List<SimpleHost> hosts, ChannelPoolHandler poolHandler) {
        this.hosts = hosts;
        this.poolHandler = poolHandler;

        this.pool = create();
    }

    public GenericObjectPool<Channel> create() {
        PooledChannelFactory factory = new PooledChannelFactory(hosts, poolHandler);

        GenericObjectPoolConfig<Channel> conf = new GenericObjectPoolConfig<>();
        conf.setMaxTotal(6);
        conf.setMaxIdle(4);
        conf.setMinIdle(2);

        conf.setMaxWaitMillis(5 * 1000);
        conf.setTestWhileIdle(true);
        conf.setTestOnBorrow(true);
        conf.setTimeBetweenEvictionRunsMillis(15 * 1000);

        GenericObjectPool<Channel> pool = new GenericObjectPool<>(factory, conf);

        return pool;
    }

    public Channel borrow() {
        try {
            return pool.borrowObject();
        } catch (Exception e) {
            throw new RuntimeException("", e);
        }
    }

    public void returnObject(Channel ch) {
        try {
            if (null != ch) {
                pool.returnObject(ch);
            }
        } catch (Exception e) {
            logger.error("return channel error", e);
        }
    }

}
