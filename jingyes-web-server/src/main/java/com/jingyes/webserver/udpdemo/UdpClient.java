package com.jingyes.webserver.udpdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP客户端
 *
 * @author chenjing
 * @date 2021/6/30
 */
public class UdpClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        ds.setSoTimeout(1000);
        //连接服务器和端口
//        connect()方法不是真连接，它是为了在客户端的DatagramSocket实例中保存服务器端的IP和端口号，
//        确保这个DatagramSocket实例只能往指定的地址和端口发送UDP包，不能往其他地址和端口发送。
//        这么做不是UDP的限制，而是Java内置了安全检查。
        ds.connect(InetAddress.getByName("localhost"), 6666);

        //发送数据
        byte[] data = "Hello".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length);
        ds.send(packet);

        //接收数据
        byte[] buffer = new byte[1024];
        packet = new DatagramPacket(buffer, buffer.length);
        ds.receive(packet);
        String resp = new String(packet.getData(), packet.getOffset(), packet.getLength());
        System.out.println("client resp:" + resp);

        //disconnect()也不是真正地断开连接，它只是清除了客户端DatagramSocket实例记录的远程服务器地址和端口号，
        // 这样，DatagramSocket实例就可以连接另一个服务器端。
        ds.disconnect();
    }
}
