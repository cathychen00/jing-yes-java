package com.jingyes.nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 两个管道通信 transferTo  transferFrom
 *
 * @author chenjing
 */
public class ChanelTransferDemo {
    public static void main(String[] args) throws IOException {
        String fromFilePath = FileChannelDemo.class.getResource("/from.txt").getFile();
        String toFilePath = fromFilePath.replace("from.txt", "to.txt");

        File file = new File(fromFilePath);
        FileInputStream inputStream = new FileInputStream(file);
        FileChannel inputChannel = inputStream.getChannel();
        FileOutputStream outputStream = new FileOutputStream(new File(toFilePath));
        FileChannel outputChannel = outputStream.getChannel();

        //将from.txt写入ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        //两个管道通信-transferTo
//        inputChannel.transferTo(0,byteBuffer.limit(),outputChannel);

        //两个管道通信-transferFrom
        outputChannel.transferFrom(inputChannel, 0, byteBuffer.limit());

        //关闭链接
        inputStream.close();
        inputChannel.close();
        outputStream.close();
        outputChannel.close();
    }
}
