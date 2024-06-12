package org.jingyes.concurrent.juc.tests.queue;

import org.junit.Test;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ConcurrentLinkedQueue
 * 线程安全的无界非阻塞队列，其底层数据结构使用单向链表实现，对于入队和出队操作使用CAS来实现线程安全。
 *
 * @author jingyes
 * @date 2020/12/23
 */
public class ConcurrentLinkedQueueTests {
    @Test
    public void testConcurrentLinkedQueue() {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.add("a");
        queue.offer("b");
        //获取
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        //由于使用非阻塞CAS算法，没有加锁，所以在计算size时有可能进行了offer、poll或者remove操作，导致计算的元素个数不精确，所以在并发情况下size函数不是很有用。
        System.out.println(queue.size());
    }
}
