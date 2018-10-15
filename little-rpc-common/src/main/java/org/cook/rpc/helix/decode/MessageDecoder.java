package org.cook.rpc.helix.decode;

/**
 *
 */
public interface MessageDecoder<T> {

    /**
     *
     * @return
     */
    byte[] encode();

    /**
     *
     * @param bs
     * @return
     */
    T decode(byte[] bs);

}
