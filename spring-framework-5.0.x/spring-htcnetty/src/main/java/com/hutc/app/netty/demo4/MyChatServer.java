package com.hutc.app.netty.demo4;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MyChatServer {
	public static void main(String[] args) throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap serverBootstrap=new ServerBootstrap();
			serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
					.childHandler(new MyChatInitializer())
					.option(ChannelOption.SO_BACKLOG, 128)          // (5)
					.childOption(ChannelOption.SO_KEEPALIVE, true); // (6)
			ChannelFuture channelFuture=serverBootstrap.bind(8899).sync();
			channelFuture.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
