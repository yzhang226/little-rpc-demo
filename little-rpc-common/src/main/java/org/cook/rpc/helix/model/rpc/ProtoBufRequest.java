package org.cook.rpc.helix.model.rpc;

import com.google.protobuf.Message;
import lombok.Getter;
import lombok.Setter;

public class ProtoBufRequest<T extends Message> extends BaseRPCRequest<T> {

    @Getter
    @Setter
    private T parameter;

    public ProtoBufRequest() {
    }

    public ProtoBufRequest(T parameter) {
        this.parameter = parameter;
    }

    public T getParameter() {
        return parameter;
    }

    public void setParameter(T parameter) {
        this.parameter = parameter;
    }
}
