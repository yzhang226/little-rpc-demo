package org.cook.rpc.helix.transfer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface RPCService {

    /**
     * 超时毫秒数
     * @return
     */
    int timeout() default 6 * 1000;



}
