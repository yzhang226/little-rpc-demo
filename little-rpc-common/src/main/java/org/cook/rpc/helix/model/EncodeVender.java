package org.cook.rpc.helix.model;


/**
 * 编解码器
 */
public enum EncodeVender {

    PROTOBUF(8, "PB");

    int code;

    String memo;

    EncodeVender(int code, String memo) {
        this.code = code;
        this.memo = memo;
    }

}
