package com.hutc.app.netty.demo3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

public class MyServerHandler extends SimpleChannelInboundHandler<String> {
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		System.out.println("服务端收到客户端地址："+ctx.channel().remoteAddress()+",服务端收到的消息："+msg);
		//服务端发送消息
		ctx.channel().writeAndFlush("from server:"+ UUID.randomUUID());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}

















