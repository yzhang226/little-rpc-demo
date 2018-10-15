package org.cook.rpc.cglib;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * Created by cook on 2018/10/11
 */
public class CglibMain {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestCglibInterface.class);
        Callback interceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("meth " + method);
//                Object ret = method.invoke(o, args);
//                Object ret = methodProxy.invokeSuper(o, args);
//                System.out.println("ref of invoke is " + ret);

                return "abcdedf";
            }
        };

        CallbackFilter filter = new CallbackFilter() {
            @Override
            public int accept(Method method) {
//                if ("test1".equals(method.getName())) {
//                    System.out.println("ignore method - " + method.getName());
//                    return 1;
//                }
                return 0;
            }
        };

        Callback[] callbacks = new Callback[]{interceptor, NoOp.INSTANCE};
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackFilter(filter);

        TestCglibInterface mo = (TestCglibInterface) enhancer.create();

        String a = mo.testA(11);
        System.out.println("--" + a);
        String b = mo.test1(22);
        System.out.println("--" + b);

    }

}
