package com.hutc.app.netty.demo4;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyChatClient {
	public static void main(String[] args) throws Exception {
		EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
		try {
			Bootstrap bootstrap=new Bootstrap();
			bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
					.handler(new MyChatClientInitializer());
			Channel channel=bootstrap.connect("localhost",8899).sync().channel();
			//channelFuture.channel().closeFuture().sync();
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
			while(true){
				String text=bufferedReader.readLine();
				channel.writeAndFlush(text+"\r\n");
				//System.out.println(text);
			}


		} finally {
			eventLoopGroup.shutdownGracefully();
		}
	}
}
