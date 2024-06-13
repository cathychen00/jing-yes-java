package com.jingyes.nio;

import java.nio.ByteBuffer;

/**
 * JAVA NIO Buffer示例
 * 参考：https://mp.weixin.qq.com/s/GfV9w2B0mbT7PmeBS45xLw?spm=a2c6h.12873639.article-detail.7.53064a61zoh75U
 * 注意：可以调试一下，看看byteBuffer中position,limit,capacity属性的变化进行理解
 */
public class ByteBufferDemo {
    public static void main(String[] args) {
        //写缓冲区
        String msg = "Hello,NIO ByteBuffer!";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byte[] bytes = msg.getBytes();
        byteBuffer.put(bytes);

        //切换到读模式。缓存区是双向的，既可以往缓冲区写入数据，也可以从缓冲区读取数据。但是不能同时进行，需要切换
        byteBuffer.flip();

        //读缓冲区
        byte[] resultBytes = new byte[bytes.length];
        int i = 0;
        while (byteBuffer.hasRemaining()) {
            resultBytes[i++] = byteBuffer.get();
        }
        System.out.println(new String(resultBytes));
    }
}
