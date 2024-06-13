package com.jingyes.webserver.udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

/**
 * UDP服务端
 * 使用UDP协议通信时，服务器和客户端双方无需建立连接：
 * <p>
 * 服务器端用DatagramSocket(port)监听端口；
 * 客户端使用DatagramSocket.connect()指定远程地址和端口；
 * 双方通过receive()和send()读写数据；
 * DatagramSocket没有IO流接口，数据被直接写入byte[]缓冲区。
 * <p>
 * * @author chenjing
 * * @date 2021/6/30
 */
public class UdpServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(6666); // 监听指定端口
        for (; ; ) {
            // 数据缓冲区:
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            //接收数据
            ds.receive(packet);
            String s = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
            System.out.println("server :" + s);

            // 发送数据:
            byte[] data = "ACK".getBytes(StandardCharsets.UTF_8);
            packet.setData(data);
            ds.send(packet);
        }
    }
}
