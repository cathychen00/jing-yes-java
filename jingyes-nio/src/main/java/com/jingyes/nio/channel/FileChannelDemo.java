package com.jingyes.nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * JAVA NIO- Channel
 * FileChannel,读写文件中的数据
 * 参考：https://mp.weixin.qq.com/s/GfV9w2B0mbT7PmeBS45xLw?spm=a2c6h.12873639.article-detail.7.53064a61zoh75U
 *
 * @author chenjing
 */
public class FileChannelDemo {
    public static void main(String[] args) throws IOException {
        String fromFilePath = FileChannelDemo.class.getResource("/from.txt").getFile();
        System.out.println(fromFilePath);
        String toFilePath = fromFilePath.replace("from.txt", "to.txt");
        System.out.println(toFilePath);

        File file = new File(fromFilePath);
        FileInputStream inputStream = new FileInputStream(file);
        FileChannel inputChannel = inputStream.getChannel();
        FileOutputStream outputStream = new FileOutputStream(new File(toFilePath));
        FileChannel outputChannel = outputStream.getChannel();

        //将from.txt写入ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        inputChannel.read(byteBuffer);
        //切换读模式
        byteBuffer.flip();
        //写入to.txt FileChannel
        outputChannel.write(byteBuffer);

        //关闭链接
        inputStream.close();
        inputChannel.close();
        outputStream.close();
        outputChannel.close();
    }
}
