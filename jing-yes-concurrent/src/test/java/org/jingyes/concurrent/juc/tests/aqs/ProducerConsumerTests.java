package org.jingyes.concurrent.juc.tests.aqs;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;

/**
 * @author chenjing
 * @date 2020/12/18
 */
public class ProducerConsumerTests {
    public static final int QUEUE_SIZE = 10;
    private static final NonReentrantLock lock = new NonReentrantLock();
    private static final Condition notFull = lock.newCondition();
    private static final Condition notEmpty = lock.newCondition();
    private static Queue<String> queue = new LinkedBlockingDeque<>();

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            lock.lock();
            try {
                while (queue.size() == QUEUE_SIZE) {
                    notFull.await();
                }
                queue.add("aaa");
                System.out.println("produce e=aaa");
                notEmpty.signalAll();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        producer.start();

        Thread consumer = new Thread(() -> {
            lock.lock();
            try {
                while (queue.size() == 0) {
                    notEmpty.await();
                }
                String e = queue.poll();
                System.out.println("consume e=" + e);
                notFull.signalAll();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        consumer.start();
    }
}
