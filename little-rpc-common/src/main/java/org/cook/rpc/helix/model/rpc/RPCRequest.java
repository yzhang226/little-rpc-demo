package org.cook.rpc.helix.model.rpc;

public interface RPCRequest<T> {

    /**
     * 获取请求入参
     * @return
     */
    T getParameter();

}
