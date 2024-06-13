package org.jingyes.concurrent.juc.tests;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenjing
 * @date 2020/12/9
 * 线程睡眠sleep()
 */
public class SleepTests {
    private static final Lock lock = new ReentrantLock();

    /**
     * sleep不会释放锁
     */
    @Test
    public void sleep_lock() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("t1 sleep");
                Thread.sleep(1000);
                System.out.println("t1 awake");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        });

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("t2 sleep");
                Thread.sleep(1000);
                System.out.println("t2 awake");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    @Test
    public void sleep_interrupt() {

    }
}
