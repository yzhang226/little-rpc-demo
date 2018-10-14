package org.cook.rpc.helix.model.rpc;

public interface RPCResponse<T> {

    /**
     * 获取响应体
     * @return 响应体
     */
    T getBody();

    /**
     * 获取响应状态
     * @return 响应状态
     */
    int getStatus();

}
