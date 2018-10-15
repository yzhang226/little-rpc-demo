package org.cook.rpc.helix.utils;

import com.google.common.collect.Maps;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Map;

public final class MessageParserFactory {

    private static final Logger logger = LoggerFactory.getLogger(MessageParserFactory.class);


    private static final Map<Class, Parser<? extends Message>> parserCache = Maps.newHashMap();

    /**
     *
     * @param msgClass
     */
    public static void registerMessageParserByClass(Class<? extends Message> msgClass) {
        if (!Message.class.isAssignableFrom(msgClass)) {
            throw new RuntimeException("message class is not protobuf Message class - " + msgClass);
        }

        if (parserCache.containsKey(msgClass)) {
            throw new RuntimeException("already registered message parser - " + msgClass);
        }

        Method method = null;
        try {
            method = msgClass.getDeclaredMethod("parser");
            Parser<Message> parser = (Parser<Message>) method.invoke(null);
            parserCache.put(msgClass, parser);
            logger.info("register parser#{} for message#{}", parser, msgClass);
        } catch (Exception e) {
            throw new RuntimeException("register message parse", e);
        }
    }

    /**
     *
     * @param msgClass
     * @return
     */
    public static Parser<? extends Message> getParser(Class<? extends Message> msgClass) {
        return parserCache.get(msgClass);
    }

}
