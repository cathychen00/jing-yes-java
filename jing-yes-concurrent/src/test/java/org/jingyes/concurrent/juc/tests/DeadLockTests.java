package org.jingyes.concurrent.juc.tests;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jingyes
 * @date 2020/12/9
 */
public class DeadLockTests {
    private static Lock resource1 = new ReentrantLock();
    private static Lock resource2 = new ReentrantLock();

    /**
     * 模拟死锁。死锁有四个条件
     * ● 互斥条件：指线程对已经获取到的资源进行排它性使用，即该资源同时只由一个线程占用。如果此时还有其他线程请求获取该资源，则请求者只能等待，直至占有资源的线程释放该资源。
     * ● 请求并持有条件：指一个线程已经持有了至少一个资源，但又提出了新的资源请求，而新资源已被其他线程占有，所以当前线程会被阻塞，但阻塞的同时并不释放自己已经获取的资源。
     * ● 不可剥夺条件：指线程获取到的资源在自己使用完之前不能被其他线程抢占，只有在自己使用完毕后才由自己释放该资源。
     * ● 环路等待条件：指在发生死锁时，必然存在一个线程—资源的环形链，即线程集合{T0, T1, T2, …, Tn}中的T0正在等待一个T1占用的资源，T1正在等待T2占用的资源，……Tn正在等待已被T0占用的资源。
     *
     * @throws InterruptedException
     */
    @Test
    public void deadlock() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("t1 get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("t1 wait for resource2");
                synchronized (resource2) {
                    System.out.println("t1 get resource2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("t2 get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("t2 wait for resource1");
                synchronized (resource1) {
                    System.out.println("t2 get resource1");
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    /**
     * 解除死锁：资源有序性
     */
    @Test
    public void solve_deadlock() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("t1 get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("t1 wait for resource2");
                synchronized (resource2) {
                    System.out.println("t1 get resource2");
                    ;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("t2 get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("t2 wait for resource2");
                synchronized (resource2) {
                    System.out.println("t2 get resource2");
                    ;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}
