package com.jingyes.j2se.tests.referencedemo;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * 虚引用示例
 *
 * @author chenjing
 * @date 2020/9/8
 */
public class PantomDemo {
    /**
     * 虚引用特点之一：无法通过虚引用来获取对一个对象的真实引用
     */
    @Test
    public void test1() {
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference<Student> phantomReference = new PhantomReference<>(new Student(1003, "Tom"), queue);
        System.out.println(phantomReference.get());
    }

    /**
     * 虚引用特点二：虚引用必须与ReferenceQueue一起使用，当GC准备回收一个对象，如果发现它还有虚引用，就会在回收之前，把这个虚引用加入到与之关联的ReferenceQueue中。
     *
     * @throws InterruptedException
     */
    @Test
    public void test2() throws InterruptedException {
        ReferenceQueue queue = new ReferenceQueue();
        List<byte[]> bytes = new ArrayList<>();
        PhantomReference<Student> reference = new PhantomReference<Student>(new Student(1004, "大海"), queue);
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                bytes.add(new byte[1024 * 1024]);
            }
        }).start();

        new Thread(() -> {
            while (true) {
                Reference poll = queue.poll();
                if (poll != null) {
                    System.out.println("虚引用被回收了：" + poll);
                }
            }
        }).start();

        Thread.sleep(10000);
    }
}
