package org.cook.rpc.helix.model.rpc;

import org.cook.rpc.helix.decode.MessageDecoder;

public interface RPCMessage<T> extends MessageDecoder<T> {

    /**
     *
     * @return
     */
    RPCHeader getHeader();

    /**
     * 消息体
     * @return 消息体
     */
    T getData();

//    /**
//     * 获取响应状态
//     * @return 响应状态
//     */
//    int getStatus();

}
