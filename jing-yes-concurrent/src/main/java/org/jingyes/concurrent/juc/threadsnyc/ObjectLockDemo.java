package org.jingyes.concurrent.juc.threadsnyc;

/**
 * 线程通信1：
 * synchronized线程同步，实现线程间的顺序执行
 */
public class ObjectLockDemo {
    //Java多线程的锁都是基于对象的
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(10);
        new Thread(new ThreadB()).start();
    }

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread A " + i);
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread B " + i);
                }
            }
        }
    }
}
