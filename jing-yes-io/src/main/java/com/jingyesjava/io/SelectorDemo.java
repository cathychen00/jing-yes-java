package com.jingyesjava.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO示例，参考：https://javaguide.cn/java/io/nio-basis.html#selector-%E9%80%89%E6%8B%A9%E5%99%A8
 */
public class SelectorDemo {

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));

            Selector selector = Selector.open();
            // 将 ServerSocketChannel 注册到 Selector 并监听 OP_ACCEPT 事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                int readyChannels = selector.select();

                if (readyChannels == 0) {
                    continue;
                }

                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();

                    if (key.isAcceptable()) {
                        // 处理连接事件
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);

                        // 将客户端通道注册到 Selector 并监听 OP_READ 事件
                        client.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        // 处理读事件
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int bytesRead = client.read(buffer);

                        if (bytesRead > 0) {
                            buffer.flip();
                            System.out.println("收到数据：" + new String(buffer.array(), 0, bytesRead));
                            // 将客户端通道注册到 Selector 并监听 OP_WRITE 事件
                            client.register(selector, SelectionKey.OP_WRITE);
                        } else if (bytesRead <= 0) {
                            // 客户端断开连接
                            client.close();
                        }
                    } else if (key.isWritable()) {
                        // 处理写事件
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.wrap("Hello, Client!".getBytes());
                        client.write(buffer);

                        // 将客户端通道注册到 Selector 并监听 OP_READ 事件
                        client.register(selector, SelectionKey.OP_READ);
                    }

                    keyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
