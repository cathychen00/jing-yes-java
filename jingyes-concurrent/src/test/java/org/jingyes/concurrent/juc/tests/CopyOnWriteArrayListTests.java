package org.jingyes.concurrent.juc.tests;

import org.junit.Test;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author chenjing
 * @date 2020/12/17
 */
public class CopyOnWriteArrayListTests {
    /**
     * CopyOnWriteArrayList使用写时复制的策略来保证list的一致性，而获取—修改—写入三步操作并不是原子性的，
     * 所以在增删改的过程中都使用了独占锁，来保证在某个时间只有一个线程能对list数组进行修改
     * <p>
     * CopyOnWriteArrayList提供了弱一致性的迭代器，从而保证在获取迭代器后，其他线程对list的修改是不可见的，迭代器遍历的数组是一个快照
     */
    @Test
    public void copyOnWriteArrayListTest() throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("aaa");
        list.add("bbb");

        Thread t = new Thread(() -> {
            list.add("ccc");
        });

        //迭代器具有弱一致性，获取迭代器后，其他线程修改list对该迭代器不可见
        Iterator<String> iterator = list.iterator();

        t.start();
        t.join();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
