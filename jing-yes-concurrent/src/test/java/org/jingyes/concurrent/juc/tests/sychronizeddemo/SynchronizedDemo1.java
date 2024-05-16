package org.jingyes.concurrent.juc.tests.sychronizeddemo;

/**
 * synchronized 是可重入锁。同一对象，不同方法可重入
 * 因为 synchronized 修饰普通方法时，使用的是对象锁，
 */
public class SynchronizedDemo1 {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo1 d = new SynchronizedDemo1();
        for (int i = 0; i < 5; i++) {
            d.test(i);
        }
    }

    public synchronized void test(Integer param) throws InterruptedException {
        System.out.println("test " + param);
        test2(param);
    }

    public synchronized void test2(Integer param) throws InterruptedException {
        System.out.println("test2 " + param);
    }
}
