package org.cook.rpc.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by cook on 2018/10/12
 */
@Aspect
public class AnnoAspect {

    @Pointcut("execution(* org.cook.rpc.aspectj.TestAspectjModel.*(..))")
    public void jointPoint() {

    }

    @Before("jointPoint()")
    public void before() {
        System.out.println("before ");
    }

    @After("jointPoint()")
    public void after() {
        System.out.println("after ");
    }

}
