package org.cook.rpc.helix.wrapper;

import com.google.common.collect.Lists;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Message;
import io.netty.channel.Channel;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.commons.lang3.ArrayUtils;
import org.cook.rpc.helix.model.rpc.ProtoBufRPCMessage;
import org.cook.rpc.helix.model.rpc.RPCHeader;
import org.cook.rpc.helix.transfer.NettyChannel;
import org.cook.rpc.helix.transfer.NettyRPCClient;
import org.cook.rpc.helix.utils.H;
import org.cook.rpc.pool.ChannelPoolConfiguration;
import org.cook.rpc.pool.MyChannelPoolHandler;
import org.cook.rpc.pool.SimpleHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.concurrent.Future;

public class MessageSendInterceptor implements MethodInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(MessageSendInterceptor.class);

    private ChannelPoolConfiguration configuration;

    public MessageSendInterceptor() {
        SimpleHost host1 = new SimpleHost("127.0.0.1", 8322);
        SimpleHost host2 = new SimpleHost("127.0.0.1", 8323);
        configuration = new ChannelPoolConfiguration(Lists.newArrayList(host1, host2), new MyChannelPoolHandler());
    }
    decode
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

//        proxy.invokeSuper(obj, args);

        Channel ch = null;
        try {
            ch = configuration.borrow();

            RPCHeader header = createHeader(method);

            Message data = Int32Value.of(1024);

            ProtoBufRPCMessage message = new ProtoBufRPCMessage(header, data);

            NettyRPCClient rpcClient = new NettyRPCClient();

            Future future = rpcClient.send(new NettyChannel(ch), message);

            Object ret = future.get();

            return ret;
        } catch (Throwable e) {
            logger.error("", e);
            throw e;
        } finally {
            configuration.returnObject(ch);

            logger.info("done ");
            System.out.println("rpcClient end");
        }

        return null;
    }

    private RPCHeader createHeader(Method method) {
        RPCHeader header = new RPCHeader();
        header.setMagic(H.MAGIC);
        header.setProtocolVersion(H.PROTOCOL_VERSION);
        header.setEncoderVendor(H.ENCODER_PB);
        header.setFlag((short) 0);// TODO:
        header.setStatus((short) 200);// TODO:
        header.setRequestId(getRequestId());
        header.setMethodMetaId(getMethodId(getInvokeMethodFlag(method)));
        header.setBodyLength(4);
        return header;
    }

    private String getInvokeMethodFlag(Method method) {
        Class retType = method.getReturnType();
        String name = method.getName();
        Class[] paramTypes = method.getParameterTypes();
        StringBuilder sb = new StringBuilder();
        sb.append(retType.getName()).append(".")
            .append(name).append("(")
        ;
        if (ArrayUtils.isNotEmpty(paramTypes)) {
            for (Class paramType : paramTypes) {
                sb.append(paramType.getName()).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(")");
        return sb.toString();
    }

    private long getMethodId(String methodName) {
        // TODO:
        return 0L;
    }

    private long getRequestId() {
        // TODO:
        return 0L;
    }

}
