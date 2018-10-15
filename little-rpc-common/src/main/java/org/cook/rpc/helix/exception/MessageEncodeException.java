package org.cook.rpc.helix.exception;

/**
 *
 */
public class MessageEncodeException extends RuntimeException {

    public MessageEncodeException(String message) {
        super(message);
    }

    public MessageEncodeException(String message, Throwable cause) {
        super(message, cause);
    }

}
