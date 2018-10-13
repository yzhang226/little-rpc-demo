package org.cook.rpc.aspectj;

/**
 * Created by cook on 2018/10/12
 */
public class TestAspectjModel {

    public String test11(String aa) {
        System.out.println("aa is " + aa);
        return "aa";
    }

    public String test22(String aa) {
        System.out.println("aa is " + aa);
        return "aa";
    }

    public static void main(String[] args) {
        TestAspectjModel model = new TestAspectjModel();
        model.test11("test111");

        model.test22("test222");
    }

}
