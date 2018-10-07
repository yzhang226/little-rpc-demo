package org.cook.rpc.sample.pool;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.pool.ChannelPoolHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by cook on 2018/10/7
 */
public class PooledChannelFactory extends BasePooledObjectFactory<Channel> {

    private static final Logger logger = LoggerFactory.getLogger(PooledChannelFactory.class);

    private List<SimpleHost> hosts;
    private ChannelPoolHandler channelPoolHandler;
    private SslContext sslCtx;

    private Bootstrap bc;

    public PooledChannelFactory(List<SimpleHost> hosts, ChannelPoolHandler channelPoolHandler) {
        this(hosts, channelPoolHandler, null);
    }

    public PooledChannelFactory(List<SimpleHost> hosts, ChannelPoolHandler channelPoolHandler, SslContext sslCtx) {
        assert CollectionUtils.isNotEmpty(hosts);
        this.hosts = hosts;
        this.channelPoolHandler = channelPoolHandler;
        this.sslCtx = sslCtx;

        EventLoopGroup group = new NioEventLoopGroup();

        this.bc = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        assert ch.eventLoop().inEventLoop();
                        channelPoolHandler.channelCreated(ch);
                    }
                })
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2000)
                .option(ChannelOption.TCP_NODELAY, true)
        ;
    }


    /**
     * Make a new connection.
     *
     * @return
     */
    private Channel createChannel() {
        SimpleHost host = selectOneHost();
        try {
            Bootstrap bs = this.bc.clone();
            ChannelFuture f = bs.connect(host.getHostAddress(), host.getPort()).sync();
            f.addListener((ChannelFutureListener) future -> {
                if (future.isSuccess()) {
                    logger.info("connected - channel#{}, host#{}:{}", f, host.getHostAddress(), host.getPort());
                }
            });

            Channel ch = f.channel();

            ch.closeFuture().addListener((ChannelFutureListener) future -> {
                logger.info("closed - channel#{}, host#{}:{}", f, host.getHostAddress(), host.getPort());
            });

            return ch;
        } catch (InterruptedException e) {
            logger.error("create channel error", e);
            throw new RuntimeException("create channel error", e);
        }

    }

    private SimpleHost selectOneHost() {
        int idx = RandomUtils.nextInt(0, hosts.size());
        return hosts.get(idx);
    }

    @Override
    public Channel create() throws Exception {
        return createChannel();
    }

    @Override
    public PooledObject<Channel> wrap(Channel obj) {
        return new DefaultPooledObject<>(obj);
    }

    @Override
    public void passivateObject(PooledObject<Channel> p) throws Exception {

    }

    @Override
    public void destroyObject(PooledObject<Channel> p) throws Exception {
        Channel ch = p.getObject();
        ch.close().addListener((ChannelFutureListener) future -> {
            logger.info("closed - channel#{} ", ch);
        });
    }

    @Override
    public boolean validateObject(PooledObject<Channel> p) {
        Channel ch = p.getObject();
        return ch.isActive();
    }

    public void shutdown() {
        this.bc.config().group().shutdownGracefully();
    }

}
