package com.hutc.app.netty.SecureChat;

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

/**
 * Handles a server-side channel.
 */
public class SecureChatServerHandler extends SimpleChannelInboundHandler<String> {

	static final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

	@Override
	public void channelActive(final ChannelHandlerContext ctx) {
		// Once session is secured, send a greeting and register the channel to the global channel
		// list so the channel received the messages from others.
		ctx.pipeline().get(SslHandler.class).handshakeFuture().addListener(
				new GenericFutureListener<Future<Channel>>() {
					@Override
					public void operationComplete(Future<Channel> future) throws Exception {
						ctx.writeAndFlush(
								"欢迎 " + InetAddress.getLocalHost().getHostName() + " 来到聊天室!\n");
						ctx.writeAndFlush(
								"您的会话受 " +
										ctx.pipeline().get(SslHandler.class).engine().getSession().getCipherSuite() +
										" 密码套件保护。\n");

						channels.add(ctx.channel());
					}
				});
	}

	@Override
	public void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		// Send the received message to all channels but the current one.
		for (Channel c: channels) {
			if (c != ctx.channel()) {
				c.writeAndFlush("[" + ctx.channel().remoteAddress() + "] " + msg + '\n');
			} else {
				c.writeAndFlush("[you] " + msg + '\n');
			}
		}

		// Close the connection if the client has sent 'bye'.
		if ("bye".equals(msg.toLowerCase())) {
			ctx.close();
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
