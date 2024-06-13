package com.jingyes.j2se.tests.referencedemo;

import org.junit.Test;

import java.lang.ref.SoftReference;

/**
 * 软引用示例 SoftReference
 * 软引用特点:当内存不足，会触发JVM的GC;
 * 如果GC后，内存还是不足，就会把软引用的包裹的对象给干掉，也就是只有在内存不足，JVM才会回收该对象。
 *
 * @author chenjing
 * @date 2020/9/8
 */
public class SoftDemo {
    /**
     * 软引用就是把对象用SoftReference包裹一下，当我们需要从软引用对象获得包裹的对象，只要get一下就可以了
     */
    @Test
    public void demo1() {
        SoftReference<Student> softReference = new SoftReference<>(new Student(10001, "王一"));
        Student student = softReference.get();
        System.out.println(student);
    }

    /**
     * 软引用特点:当内存不足，会触发JVM的GC;
     * 如果GC后，内存还是不足，就会把软引用的包裹的对象给干掉，也就是只有在内存不足，JVM才会回收该对象。
     * 运行vm参数：-Xmx20M
     */
    @Test
    public void demo2() {
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(softReference.get());
        System.gc();
        System.out.println(softReference.get());

        byte[] bytes = new byte[1024 * 1024 * 10];
        System.out.println(softReference.get());
    }
}
