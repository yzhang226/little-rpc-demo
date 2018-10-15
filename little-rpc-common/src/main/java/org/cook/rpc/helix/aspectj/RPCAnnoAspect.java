package org.cook.rpc.helix.aspectj;

import com.google.common.collect.Lists;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Message;
import io.netty.channel.Channel;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.cook.rpc.helix.model.rpc.ProtoBufRPCMessage;
import org.cook.rpc.helix.model.rpc.RPCHeader;
import org.cook.rpc.helix.model.rpc.RPCMessage;
import org.cook.rpc.helix.transfer.NettyChannel;
import org.cook.rpc.helix.transfer.NettyRPCClient;
import org.cook.rpc.helix.utils.H;
import org.cook.rpc.pool.ChannelPoolConfiguration;
import org.cook.rpc.pool.MyChannelPoolHandler;
import org.cook.rpc.pool.SimpleHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

@Aspect
public class RPCAnnoAspect {

    private static final Logger logger = LoggerFactory.getLogger(RPCAnnoAspect.class);

    private ChannelPoolConfiguration configuration;

    public RPCAnnoAspect() {
        SimpleHost host1 = new SimpleHost("127.0.0.1", 8322);
        SimpleHost host2 = new SimpleHost("127.0.0.1", 8323);

        configuration = new ChannelPoolConfiguration(Lists.newArrayList(host1, host2), new MyChannelPoolHandler());
    }

//    @Pointcut("@annotation(org.cook.rpc.helix.transfer.RPCService)")
//    @Pointcut("execution(public * @org.cook.rpc.helix.transfer.RPCService *.*(..))")
//    public void rpcServiceJoin() {
//
//    }

//    @Pointcut("execution(@org.cook.rpc.rpc.OneAnno * *(..))")
//    public void beanAnnotatedWithMonitor() {}

//    @Pointcut("within(@org.cook.rpc.helix.transfer.RPCService *)")
//    @Pointcut("execution(@org.cook.rpc.helix.transfer.RPCService * *(..))")
    @Pointcut("execution(public * ((@org.cook.rpc.helix.transfer.RPCService *)+).*(..)) && within(@org.cook.rpc.helix.transfer.RPCService *)")
    public void beanAnnotatedWithMonitor() {}

//    @Around("execution(* (@org.cook.rpc.helix.transfer.RPCService *).*(..))")
//    @Around("execution(public * ((@org.cook.rpc.helix.transfer.RPCService *)+).*(..)) && within(@org.cook.rpc.helix.transfer.RPCService *)")
    @Around("beanAnnotatedWithMonitor()")
    public Object rpcClient(ProceedingJoinPoint join) throws Throwable {
        System.out.println("rpcClient begin");
        Method method = MethodSignature.class.cast(join.getSignature()).getMethod();
        Class retType = method.getReturnType();
        Class<?>[] paramClasses = method.getParameterTypes();

        if (!(RPCMessage.class.isAssignableFrom(retType))) {
            throw new RuntimeException("rpc return type must be type of RPCResponse");
        }

        if (ArrayUtils.isNotEmpty(paramClasses) && paramClasses.length > 1) {
            throw new RuntimeException("rpc input parameter must be one param");
        }

        Class paramClazz = ArrayUtils.isEmpty(paramClasses) ? null : paramClasses[0];

        if (paramClazz != null && !(RPCMessage.class.isAssignableFrom(paramClazz))) {
            throw new RuntimeException("rpc parameter type must be type of RPCRequest");
        }


        Channel ch = null;
        try {
            ch = configuration.borrow();

            RPCHeader header = new RPCHeader();
            header.setMagic(H.MAGIC);
            header.setProtocolVersion(H.PROTOCOL_VERSION);
            header.setEncoderVendor(H.ENCODER_PB);
            header.setFlag((short) 0);// TODO:
            header.setStatus((short) 200);// TODO:
            header.setRequestId(10L);
            header.setMethodMetaId(10L);
            header.setBodyLength(4);

            Message data = Int32Value.of(1024);

            ProtoBufRPCMessage message = new ProtoBufRPCMessage(header, data);

            NettyRPCClient rpcClient = new NettyRPCClient();

            rpcClient.send(new NettyChannel(ch), message);

            Object ret = join.proceed();

            return ret;
        } catch (Throwable e) {
            logger.error("", e);
            throw e;
        } finally {
            configuration.returnObject(ch);

            logger.info("done ");
            System.out.println("rpcClient end");
        }
    }

}
