package org.cook.rpc.helix.wrapper;

import com.google.common.collect.Maps;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.util.Map;

public class ClientWrapper {

    private static final Map<Class, Object> serviceCache = Maps.newHashMap();

    public Object getOrCreateWrapper(Class clazz) {
        if (clazz == null || !clazz.isInterface()) {
            throw new RuntimeException("class#" + clazz + " is illegal");
        }

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        Callback interceptor = new MessageSendInterceptor();

        Callback[] callbacks = new Callback[]{interceptor, NoOp.INSTANCE};
        enhancer.setCallbacks(callbacks);

        return enhancer.create();
    }

    public static void main(String[] args) {

    }

}
