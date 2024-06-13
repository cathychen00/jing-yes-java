package com.jingyes.nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * 管道支持分散读取，聚合写入
 *
 * @author chenjing
 */
public class GatherScatterDemo {
    public static void main(String[] args) throws IOException {
        String fromFilePath = FileChannelDemo.class.getResource("/from.txt").getFile();
//        System.out.println(fromFilePath);
        String toFilePath = fromFilePath.replace("from.txt", "to.txt");
//        System.out.println(toFilePath);

        File file = new File(fromFilePath);
        FileInputStream inputStream = new FileInputStream(file);
        FileChannel inputChannel = inputStream.getChannel();
        FileOutputStream outputStream = new FileOutputStream(new File(toFilePath));
        FileChannel outputChannel = outputStream.getChannel();

        //将from.txt写入ByteBuffer
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(5);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(5);
        ByteBuffer byteBuffer3 = ByteBuffer.allocate(5);

        ByteBuffer[] byteBuffers = new ByteBuffer[]{byteBuffer1, byteBuffer2, byteBuffer3};

        long read, sumLength = 0L;
        while ((read = inputChannel.read(byteBuffers)) != -1) {
            sumLength += read;
            Arrays.stream(byteBuffers).map(x -> "position=" + x.position() + " limit=" + x.limit())
                    .forEach(System.out::println);
            Arrays.stream(byteBuffers).forEach(ByteBuffer::flip);
            outputChannel.write(byteBuffers);
            Arrays.stream(byteBuffers).forEach(ByteBuffer::clear);

            System.out.println("sum length=" + sumLength);
        }

        //关闭链接
        inputStream.close();
        inputChannel.close();
        outputStream.close();
        outputChannel.close();
    }
}
