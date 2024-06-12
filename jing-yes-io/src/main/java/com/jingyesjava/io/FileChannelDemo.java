
package com.jingyesjava.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * BIO-Channel 测试FileChannel读写文件
 *
 * @author jingyes
 * @date 2024/5/30
 */
public class FileChannelDemo {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\data\\testlogs\\test.txt";
        RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
        //Channel
        FileChannel channel = raf.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //创建时默认写模式，切换读模式
        buffer.flip();
        channel.read(buffer);
        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }

        //写入
        raf = new RandomAccessFile("D:\\data\\testlogs\\test_3.txt", "rw");
        FileChannel channel2 = raf.getChannel();
        channel2.write(buffer);
    }
}
