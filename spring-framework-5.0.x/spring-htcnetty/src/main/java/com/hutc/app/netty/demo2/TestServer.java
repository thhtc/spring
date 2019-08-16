package com.hutc.app.netty.demo2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TestServer {
	public static void main(String[] args) throws  Exception {
		//NioEventLoopGroup是一个处理I/O操作的多线程事件循环
		//bossGroup作为boss,接收传入连接
		//bossGroup只负责接收客户端的连接，不做复杂操作，为了减少资源占用，取值越小越好
		//Group：群组，Loop：循环，Event：事件，这几个东西联在一起，相比大家也大概明白它的用途了。
		//Netty内部都是通过线程在处理各种数据，EventLoopGroup就是用来管理调度他们的，注册Channel，管理他们的生命周期。
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		//workerGroup作为worker，处理boss接收的连接的流量和将接收的连接注册进入这个worker
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap serverBootstrap=new ServerBootstrap();
			serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
					.childHandler(new TestServerInitializer());
			ChannelFuture channelFuture=serverBootstrap.bind(8899).sync();
			channelFuture.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}


	}

}
