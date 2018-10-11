package org.cook.rpc.cglib;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

/**
 * Created by cook on 2018/10/11
 */
public class TestCglibModel {

    public String printHello() {
        System.out.println("hello cglib inner");
        return RandomStringUtils.randomAlphabetic(10);
    }

    public void test1() {
        System.out.println("test1");
    }

    public void test2() {
        System.out.println("test2");
    }

}
