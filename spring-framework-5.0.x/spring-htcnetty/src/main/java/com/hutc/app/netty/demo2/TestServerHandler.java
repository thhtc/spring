package com.hutc.app.netty.demo2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;


public class TestServerHandler extends SimpleChannelInboundHandler<HttpObject> {
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
		if(msg instanceof  HttpRequest) {
			HttpRequest request=(HttpRequest)msg;
			URI uri=new URI(request.uri());
			if("/favicon.ico".equals(uri.getPath())){
				System.out.println("request favicon.ico");
				return;
			}
			//服务端发送消息
			ByteBuf context = Unpooled.copiedBuffer("hello htc", CharsetUtil.UTF_8);
			FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1
					, HttpResponseStatus.OK, context);
			response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
			response.headers().set(HttpHeaderNames.CONTENT_LENGTH, context.readableBytes());
			ctx.writeAndFlush(response);
		}
	}

}
