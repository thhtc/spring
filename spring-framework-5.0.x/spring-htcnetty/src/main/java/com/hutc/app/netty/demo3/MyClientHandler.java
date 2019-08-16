package com.hutc.app.netty.demo3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;
import java.util.UUID;

public class MyClientHandler extends SimpleChannelInboundHandler<String> {
	/**
	 * 服务器向客户端发送消息时触发channelRead0
	 * @param ctx
	 * @param msg
	 * @throws Exception
	 */
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		System.out.println("客户端收到服务器地址："+ctx.channel().remoteAddress()+",客户端收到的消息："+msg);
		//客户端向服务器发送消息
		ctx.channel().writeAndFlush("from Client:"+ LocalDateTime.now());
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush("你好！我来自客户端！");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}