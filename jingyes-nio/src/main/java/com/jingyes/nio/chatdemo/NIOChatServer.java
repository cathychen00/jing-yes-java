package com.jingyes.nio.chatdemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class NIOChatServer {
    public static final int port = 9999;
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public NIOChatServer() throws IOException {
        this.selector = Selector.open();
        this.serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", port);
        serverSocketChannel.bind(address);

        //channel必须设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //绑定channel到selector
        this.serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public static void main(String[] args) throws IOException {
        NIOChatServer chatServer = new NIOChatServer();
        chatServer.listen();
    }

    public void listen() {
        while (true) {
            try {
                if (this.selector.select(3000) == 0) {
                    System.out.println("服务器等待3秒");
                    continue;
                }

                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                while (it.hasNext()) {
                    //获取事件
                    SelectionKey selectionKey = it.next();
                    //建立连接
                    if (selectionKey.isAcceptable()) {
                        SocketChannel socketChannel = this.serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        //把socketChannel注册到selector中，监听读事件，并绑定一个缓冲区
                        socketChannel.register(this.selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                        System.out.println(socketChannel.getRemoteAddress() + "上线了");
                    }
                    //读数据
                    else if (selectionKey.isReadable()) {
                        if (selectionKey.channel() instanceof SocketChannel) {
                            SocketChannel channel = (SocketChannel) selectionKey.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            channel.read(byteBuffer);

                            String msg = new String(byteBuffer.array());
                            notifyAllClients(msg, channel);
                            System.out.println("从客户端读取" + new String(byteBuffer.array()));
                        }
                    }

                    it.remove();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void notifyAllClients(String msg, SocketChannel excludeChannel) throws IOException {
//        selector.keys 返回当前所有注册在selector中channel的selectionKey
//        selector.selectedKeys() 返回注册在selector中等待IO操作(及有事件发生)channel的selectionKey
        Set<SelectionKey> selectionKeys = this.selector.keys();
        for (SelectionKey key : selectionKeys) {
            Channel channel = key.channel();
            if (channel instanceof SocketChannel && channel != excludeChannel) {
                SocketChannel socketChannel = (SocketChannel) channel;
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8));
                socketChannel.write(byteBuffer);
            }
        }
    }
}
