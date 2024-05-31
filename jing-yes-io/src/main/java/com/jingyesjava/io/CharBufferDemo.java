package com.jingyesjava.io;

import java.nio.CharBuffer;

/**
 * NIO - Buffer几个属性示例
 *
 * @author 陈敬
 * @date 2024/5/30
 */
public class CharBufferDemo {
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(10);
        System.out.println("**********初始化**********");
        printCharBuffer(buffer);

        buffer.put('a');
        buffer.put('b');
        buffer.put('c');
        buffer.put('d');
        System.out.println("**********put**********");
        printCharBuffer(buffer);

        buffer.flip();
        System.out.println("**********flip**********");
        printCharBuffer(buffer);

        buffer.clear();
        System.out.println("**********clear**********");
        printCharBuffer(buffer);
    }

    private static void printCharBuffer(CharBuffer buffer) {
        System.out.printf("capacity: %d\n", buffer.capacity());
        System.out.printf("limit: %d\n", buffer.capacity());
        System.out.printf("position:%d \n", buffer.position());
    }
}
