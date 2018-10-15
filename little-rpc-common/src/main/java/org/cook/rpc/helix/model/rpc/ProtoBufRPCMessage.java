package org.cook.rpc.helix.model.rpc;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import org.cook.rpc.helix.exception.MessageEncodeException;
import org.cook.rpc.helix.utils.MessageParserFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 */
public class ProtoBufRPCMessage extends BaseRPCMessage<Message> {

    public ProtoBufRPCMessage(RPCHeader header, Message data) {
        super(header, data);
        MessageParserFactory.registerMessageParserByClass(messageClass);
    }

    @Override
    public byte[] encode() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            getData().writeTo(baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new MessageEncodeException("encode message exception", e);
        }
    }

    @Override
    public Message decode(byte[] bs) {
        try {
            Parser<? extends Message> parser = MessageParserFactory.getParser(messageClass);
            Message data = parser.parseFrom(bs);
            return data;
        } catch (InvalidProtocolBufferException e) {
            throw new MessageEncodeException("", e);
        }
    }

}
