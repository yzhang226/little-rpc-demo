package org.cook.rpc.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by cook on 2018/10/11
 */
public class MyLogInvokeHandler implements InvocationHandler {

    private Object target;

    public MyLogInvokeHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("before proxy is " + proxy + ", target is " + target);
        //  + ", proxy is " + proxy
        System.out.println("before - target is" + target);
        Object ret = method.invoke(target, args);
        System.out.println("after - proxy is " );
        return ret;
    }
}
