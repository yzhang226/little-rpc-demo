package org.cook.rpc.helix.transfer;

import java.util.concurrent.Future;

public interface RPCChannel {

    /**
     * write <code>data</code> to channel
     * @param data
     */
    Future write(byte[] data);

    /**
     * flush channel
     */
    void flush();

    /**
     * write <code>data</code> to channel and flush channel
     * @param data
     */
    Future writeAndFlush(byte[] data);

}
