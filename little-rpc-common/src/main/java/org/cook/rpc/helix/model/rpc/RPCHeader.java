package org.cook.rpc.helix.model.rpc;

public class RPCHeader {

    private short magic;

    private byte protocolVersion;

    private byte encoderVendor;

    private short flag;

    private short status;

    private long requestId;

    private long methodMetaId;

    private int bodyLength;

    public short getMagic() {
        return magic;
    }

    public void setMagic(short magic) {
        this.magic = magic;
    }

    public byte getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(byte protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public byte getEncoderVendor() {
        return encoderVendor;
    }

    public void setEncoderVendor(byte encoderVendor) {
        this.encoderVendor = encoderVendor;
    }

    public short getFlag() {
        return flag;
    }

    public void setFlag(short flag) {
        this.flag = flag;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public long getMethodMetaId() {
        return methodMetaId;
    }

    public void setMethodMetaId(long methodMetaId) {
        this.methodMetaId = methodMetaId;
    }

    public int getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(int bodyLength) {
        this.bodyLength = bodyLength;
    }
}
