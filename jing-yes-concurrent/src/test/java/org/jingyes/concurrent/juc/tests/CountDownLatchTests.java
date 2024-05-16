package org.jingyes.concurrent.juc.tests;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch 示例
 * @author chenjing
 * @date 2020/12/29
 */
public class CountDownLatchTests {
    //Thread方式
    @Test
    public void test() {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("线程1执行完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("线程2执行完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        });

        t.start();
        t2.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完成");
    }

    //ExecutorService方式
    @Test
    public void test2() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("线程1执行完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        });

        executorService.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("线程2执行完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        });

        countDownLatch.await();
        System.out.println("执行完成");
    }
}
