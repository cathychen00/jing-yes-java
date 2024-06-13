package org.jingyes.concurrent.juc.tests;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * * ReentrantLock的底层是使用AQS实现的可重入独占锁。
 * * 在这里AQS状态值为0表示当前锁空闲，为大于等于1的值则说明该锁已经被占用。
 * * 该锁内部有公平与非公平实现，默认情况下是非公平的实现。
 * * 另外，由于该锁是独占锁，所以某时只有一个线程可以获取该锁。
 *
 * @author jingyes
 * @date 2020/12/17
 */
public class ReentrantLockTests {
    ReentrantLock lock = new ReentrantLock();

    @Test
    public void test_reentrantlock() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            testSync();
        });
        t1.setName("t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            testSync();
        });
        t2.setName("t2");
        t2.start();

        t1.join();
        t2.join();
    }

    private void testSync() {
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Test
    public void testCondition() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread t = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("begin await");
                condition.await();
                System.out.println("end await");
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }

            lock.lock();
        });
        t.start();

        Thread.sleep(1000);
        lock.lock();
        try {
            System.out.println("begin signal");
            condition.signal();
            System.out.println("end signal");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
