package org.cook.rpc.rpc;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TestAnnoAspectj {

    private static final Logger logger = LoggerFactory.getLogger(TestAnnoAspectj.class);

//    @Pointcut("within(@org.cook.rpc.rpc.OneAnno *)")
    @Pointcut("execution(@org.cook.rpc.rpc.OneAnno * *(..))")
    public void beanAnnotatedWithMonitor() {}

    @Pointcut("execution(public * *(..))")
    public void publicMethod() {}

    @Pointcut("publicMethod() && beanAnnotatedWithMonitor()")
    public void publicMethodInsideAClassMarkedWithAtMonitor() {}

    @Around("beanAnnotatedWithMonitor()")
    public Object rpcClient(ProceedingJoinPoint join) throws Throwable {
        System.out.println("begin ...");
        try {

            Object ret = join.proceed();

            return ret;
        } catch (Throwable e) {
            logger.error("", e);
            throw e;
        } finally {
            logger.info("done ");
            System.out.println("end");
        }

    }
}
