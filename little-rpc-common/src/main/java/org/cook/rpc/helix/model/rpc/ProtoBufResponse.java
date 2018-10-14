package org.cook.rpc.helix.model.rpc;

import com.google.protobuf.Message;
import lombok.Getter;
import lombok.Setter;

public class ProtoBufResponse<T extends Message> extends BaseRPCResponse<T> {

    @Getter
    @Setter
    private T body;

    public ProtoBufResponse() {
    }

    public ProtoBufResponse(T body, int status) {
        this.body = body;
        super.setStatus(status);
    }

    public static <T extends Message> ProtoBufResponse wrap(T body) {
        return new ProtoBufResponse<>(body, 0);
    }

    public static <T extends Message> ProtoBufResponse wrap(T body, int status) {
        return new ProtoBufResponse<>(body, status);
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
