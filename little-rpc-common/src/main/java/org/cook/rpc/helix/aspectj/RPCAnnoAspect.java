package org.cook.rpc.helix.aspectj;

import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.cook.rpc.helix.model.rpc.RPCRequest;
import org.cook.rpc.helix.model.rpc.RPCResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

@Aspect
public class RPCAnnoAspect {

    private static final Logger logger = LoggerFactory.getLogger(RPCAnnoAspect.class);

//    @Pointcut("@annotation(org.cook.rpc.helix.transfer.RPCService)")
//    @Pointcut("execution(public * @org.cook.rpc.helix.transfer.RPCService *.*(..))")
//    public void rpcServiceJoin() {
//
//    }

//    @Pointcut("execution(@org.cook.rpc.rpc.OneAnno * *(..))")
//    public void beanAnnotatedWithMonitor() {}

//    @Pointcut("within(@org.cook.rpc.helix.transfer.RPCService *)")
    @Pointcut("execution(@org.cook.rpc.helix.transfer.RPCService * *(..))")
    public void beanAnnotatedWithMonitor() {}

//    @Around("execution(* (@org.cook.rpc.helix.transfer.RPCService *).*(..))")
//    @Around("execution(public * ((@org.cook.rpc.helix.transfer.RPCService *)+).*(..)) && within(@org.cook.rpc.helix.transfer.RPCService *)")
    @Around("beanAnnotatedWithMonitor()")
    public Object rpcClient(ProceedingJoinPoint join) throws Throwable {
        System.out.println("rpcClient begin");
        Method method = MethodSignature.class.cast(join.getSignature()).getMethod();
        Class retType = method.getReturnType();
        Class<?>[] paramClasses = method.getParameterTypes();

        if (!(RPCResponse.class.isAssignableFrom(retType))) {
            throw new RuntimeException("rpc return type must be type of RPCResponse");
        }

        if (ArrayUtils.isNotEmpty(paramClasses) && paramClasses.length > 1) {
            throw new RuntimeException("rpc input parameter must be one param");
        }

        Class paramClazz = ArrayUtils.isEmpty(paramClasses) ? null : paramClasses[0];

        if (paramClazz != null && !(RPCRequest.class.isAssignableFrom(paramClazz))) {
            throw new RuntimeException("rpc parameter type must be type of RPCRequest");
        }

        try {

            Object ret = join.proceed();

            return ret;
        } catch (Throwable e) {
            logger.error("", e);
            throw e;
        } finally {
            logger.info("done ");
            System.out.println("rpcClient end");
        }
    }

}
