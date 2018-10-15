package org.cook.rpc;

import net.sf.cglib.proxy.*;
import org.cook.rpc.cglib.TestCglibInterface;
import org.cook.rpc.helix.model.protobuf.PBHeartbeatModel;
import org.cook.rpc.sample.ping.SimplePingService;

import java.lang.reflect.Method;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        SimplePingService pingService = new SimplePingService();
        pingService.ping(PBHeartbeatModel.newBuilder().setBeat(3333).build());

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestCglibInterface.class);
        Callback interceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("meth " + method);
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
