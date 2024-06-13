package com.jingyes.j2se.tests.referencedemo;

import org.junit.Test;

import java.lang.ref.WeakReference;

/**
 * 弱引用示例
 * 关键字 WeakReference；
 * 弱引用的特点是不管内存是否足够，只要发生GC，都会被回收；
 * 弱引用在很多地方都有用到，比如ThreadLocal、WeakHashMap
 *
 * @author chenjing
 * @date 2020/9/8
 */
public class WeekDemo {
    @Test
    public void test1() {
        WeakReference<Student> weak = new WeakReference<>(new Student(10002, "sandy"));
        System.out.println(weak.get());
        System.gc();
        System.out.println(weak.get());

        //运行结果
//        Student{id=10002, name='sandy'}
//        null
    }
}
