package org.cook.rpc.jdk;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by cook on 2018/10/11
 */
public class AuthSimple implements AuthInterface {

    @Override
    public String sayIt(String name) {
        System.out.println("name is " + name);
        return RandomStringUtils.randomAlphabetic(15);
    }
}
