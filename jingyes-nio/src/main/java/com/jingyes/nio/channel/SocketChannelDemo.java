package com.jingyes.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {
    public static void main(String[] args) throws IOException {
        //构建ServerSocketChannel
        ServerSocketChannel channel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9999);
        channel.bind(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            SocketChannel socketChannel = channel.accept();
            while (socketChannel.read(byteBuffer) != -1) {
                System.out.println(new String(byteBuffer.array()));
                byteBuffer.clear();
            }
        }
    }
    //使用telnet测试
}
