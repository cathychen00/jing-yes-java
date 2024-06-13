package org.jingyes.concurrent.juc.tests;

import org.junit.Test;

/**
 * @author chenjing
 * @date 2020/12/9
 * Object类wait(),notify()
 */
public class DemoTests {
    private static final String LOCK = "lock";
    private static final Integer CAPACITY = 10;
    private static Integer count = 0;

    @Test
    public void test() {
        DemoTests demo = new DemoTests();
        new Thread(demo.new Producer()).start();
        new Thread(demo.new Consumer()).start();
        new Thread(demo.new Consumer()).start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            synchronized (LOCK) {
                while (count.equals(CAPACITY)) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count++;
                System.out.println("producer count=" + count);
                LOCK.notifyAll();
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            synchronized (LOCK) {
                while (count.equals(0)) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                System.out.println("consumer count=" + count);
                LOCK.notifyAll();
            }
        }
    }
}
