package org.cook.rpc.helix.model.rpc;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseRPCMessage<T> implements RPCMessage {

    protected RPCHeader header;

    protected T data;

    protected Class<T> messageClass;

    public BaseRPCMessage() {
        messageClass = getSuperClassGenericType(getClass(), 0);
    }

    public BaseRPCMessage(RPCHeader header, T data) {
        this();
        this.header = header;
        this.data = data;
    }

    @Override
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public RPCHeader getHeader() {
        return header;
    }

    public void setHeader(RPCHeader header) {
        this.header = header;
    }

    public static Class getSuperClassGenericType(final Class<?> clazz, final int index) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }

        return (Class<?>) params[index];
    }

}
