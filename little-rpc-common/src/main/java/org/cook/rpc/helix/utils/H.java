package org.cook.rpc.helix.utils;

import org.cook.rpc.helix.model.rpc.RPCHeader;

public final class H {

    public static final short MAGIC = (short) 0xEDED;

    public static final byte PROTOCOL_VERSION = (byte) 0x1;

    public static final byte ENCODER_PB = (byte) 0x8;

    // flag



    public static final int LENGTH_HEADER = 28;

    /**
     * 转换 字节数组 为 Header
     * @param data
     * @return
     */
    public static RPCHeader toHeader(byte[] data) {
        RPCHeader header = new RPCHeader();
        header.setMagic(parseShort(data, 0));
        header.setProtocolVersion(parseByte(data, 2));
        header.setEncoderVendor(parseByte(data, 3));
        header.setFlag(parseShort(data, 4));
        header.setStatus(parseShort(data, 6));
        header.setRequestId(parseLong(data, 8));
        header.setMethodMetaId(parseLong(data, 16));
        header.setBodyLength(parseInt(data, 24));
        return header;
    }

    /**
     * 转换 header 为 字节数组
     * @param header
     * @return
     */
    public static byte[] toBytes(RPCHeader header) {
        byte[] data = new byte[LENGTH_HEADER];

        allocate(data, 0, header.getMagic());
        allocate(data, 2, header.getProtocolVersion());
        allocate(data, 3, header.getEncoderVendor());
        allocate(data, 4, header.getFlag());
        allocate(data, 6, header.getStatus());

        allocate(data, 8, header.getRequestId());
        allocate(data, 16, header.getMethodMetaId());

        allocate(data, 24, header.getBodyLength());

        return data;
    }

    /**
     * 高位在前 -
     * @param val
     * @return
     */
    public static byte[] toBytes(int val) {
        byte[] data = new byte[4];
        allocate(data, 0, val);
        return data;
    }



    public static void allocate(byte[] buffer, int offset, byte val) {
        buffer[offset] = val;
    }

    public static void allocate(byte[] buffer, int offset, short val) {
        buffer[offset + 1] = (byte) val;
        buffer[offset] = (byte) (val >>> 8);
    }

    public static void allocate(byte[] buffer, int offset, int val) {
        buffer[offset + 3] = (byte) val;
        buffer[offset + 2] = (byte) (val >>> 8);
        buffer[offset + 1] = (byte) (val >>> 16);
        buffer[offset] = (byte) (val >>> 24);
    }

    public static void allocate(byte[] buffer, int offset, long val) {
        buffer[offset + 7] = (byte) val;
        buffer[offset + 6] = (byte) (val >>> 8);
        buffer[offset + 5] = (byte) (val >>> 16);
        buffer[offset + 4] = (byte) (val >>> 24);
        buffer[offset + 3] = (byte) (val >>> 32);
        buffer[offset + 2] = (byte) (val >>> 40);
        buffer[offset + 1] = (byte) (val >>> 48);
        buffer[offset] = (byte) (val >>> 56);
    }

    public static byte parseByte(byte[] buffer, int offset) {
        return buffer[offset];
    }

    public static short parseShort(byte[] buffer, int offset) {
        short val = (short) (buffer[offset + 2] << 8);
        val += buffer[offset + 3];
        return val;
    }

    public static int parseInt(byte[] buffer, int offset) {
        int val = buffer[offset] << 24;
        val += buffer[offset + 1] << 16;
        val += buffer[offset + 2] << 8;
        val += buffer[offset + 3];
        return val;
    }

    public static long parseLong(byte[] buffer, int offset) {
        long val = buffer[offset] << 56;
        val += buffer[offset + 1] << 48;
        val += buffer[offset + 2] << 40;
        val += buffer[offset + 3] << 32;
        val += buffer[offset + 4] << 24;
        val += buffer[offset + 5] << 16;
        val += buffer[offset + 6] << 8;
        val += buffer[offset + 7];
        return val;
    }


}
