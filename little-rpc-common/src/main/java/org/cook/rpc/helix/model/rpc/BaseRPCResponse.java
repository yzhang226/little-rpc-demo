package org.cook.rpc.helix.model.rpc;

import lombok.Getter;
import lombok.Setter;

public abstract class BaseRPCResponse<T> implements RPCResponse<T> {

    @Getter
    @Setter
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
