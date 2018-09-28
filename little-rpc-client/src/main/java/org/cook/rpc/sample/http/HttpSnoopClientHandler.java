package org.cook.rpc.sample.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class HttpSnoopClientHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    public void channelRead0(ChannelHandlerContext ctx, HttpObject msg) {
//        System.out.println("client receive msg is " + msg);
        StringBuilder sb = new StringBuilder();
        if (msg instanceof HttpResponse) {
            HttpResponse response = (HttpResponse) msg;

            appendln(sb,"STATUS: " + response.status());
            appendln(sb,"VERSION: " + response.protocolVersion());
            appendln(sb, "");

            if (!response.headers().isEmpty()) {
                for (CharSequence name : response.headers().names()) {
                    for (CharSequence value : response.headers().getAll(name)) {
                        appendln(sb,"HEADER: " + name + " = " + value);
                    }
                }
                appendln(sb, "");
            }

            if (HttpUtil.isTransferEncodingChunked(response)) {
                appendln(sb,"CHUNKED CONTENT {");
            } else {
                appendln(sb,"CONTENT {");
            }
        }
        if (msg instanceof HttpContent) {
            HttpContent content = (HttpContent) msg;

            append(sb, content.content().toString(CharsetUtil.UTF_8));
//            System.out.flush();

            if (content instanceof LastHttpContent) {
                appendln(sb,"} END OF CONTENT");
                ctx.close();
            }
        }
        System.out.println(sb.toString());
    }

    private void appendln(StringBuilder sb, String content) {
        sb.append(content).append("\n");
    }

    private void append(StringBuilder sb, String content) {
        sb.append(content);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}