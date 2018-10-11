package org.cook.rpc.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by cook on 2018/10/11
 */
public class JdkProxyMain {

    public static void main(String[] args) throws Exception {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.out.println(System.getProperty("user.dir"));

        InvocationHandler handler = new MyLogInvokeHandler(new AuthSimple());
        ClassLoader classloader = AuthInterface.class.getClassLoader();

        testGetProxyClass_2();

//        Class proxyClazz = Proxy.getProxyClass(AuthInterface.class.getClassLoader(), AuthInterface.class);
//        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
//        AuthInterface iter = (AuthInterface) constructor.newInstance(new MyLogInvokeHandler(new AuthSimple()));

        AuthInterface iter  = (AuthInterface) Proxy.newProxyInstance(classloader,
                AuthSimple.class.getInterfaces(),
                handler
                );

        iter.sayIt("test1");

//        iter.sayIt("test2");

    }

    public static void testGetProxyClass_2(){
        // 获取代理类的字节码
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy11", AuthSimple.class.getInterfaces());
        // 写入文件
        String path = "/exchange/bin/$Proxy1.class";
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
