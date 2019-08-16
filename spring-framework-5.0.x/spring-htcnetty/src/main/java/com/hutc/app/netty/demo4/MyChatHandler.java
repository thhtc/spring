package com.hutc.app.netty.demo4;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.ssl.SslHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.net.InetAddress;


public class MyChatHandler extends  SimpleChannelInboundHandler<String> {
	private static ChannelGroup channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		Channel channel=ctx.channel();
		for (Channel ch : channelGroup) {
			if(channel!=ch){
				ch.writeAndFlush(channel.remoteAddress()+" 发送的消息:"+msg+ '\n');
			}else {
				ch.writeAndFlush("自己发送的消息:"+msg+ '\n');
				//channel.writeAndFlush("自己发的消息:"+msg);
			}
		}

	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		Channel channel=ctx.channel();
		for (Channel ch : channelGroup) {
			ch.writeAndFlush("[SERVER] - " + channel.remoteAddress() + " 加入\n");
		}
		channelGroup.add(channel);
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		Channel channel=ctx.channel();
		channelGroup.writeAndFlush("[服务器]- "+channel.remoteAddress()+"离开\n");
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		Channel channel=ctx.channel();
		System.out.println(channel.remoteAddress()+"上线");
		//channelGroup.add(channel);

	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		Channel channel=ctx.channel();
		System.out.println(channel.remoteAddress()+"下线");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}