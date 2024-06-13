package org.jingyes.concurrent.juc.tests;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 简单的生产者消费者模式
 *
 * @author jingyes
 * @date 2020/12/18
 */
public class ProducerConsumerTests {
    public static final int QUEUE_SIZE = 10;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition notFull = lock.newCondition();
    private static final Condition notEmpty = lock.newCondition();
    private static final Queue<String> queue = new LinkedBlockingDeque<>();
    private static final AtomicInteger num = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == QUEUE_SIZE) {
                        notFull.await();
                    }
                    Thread.sleep(200);
                    String itemName = "item" + num.incrementAndGet();
                    queue.add(itemName);
                    System.out.println("produce " + itemName);
                    notEmpty.signal();
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        producer.start();

        Thread consumer = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        notEmpty.await();
                    }
                    Thread.sleep(200);
                    String e = queue.poll();
                    System.out.println("consume " + e);
                    notFull.signal();
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        consumer.start();

        Thread.sleep(10000);
    }
}
