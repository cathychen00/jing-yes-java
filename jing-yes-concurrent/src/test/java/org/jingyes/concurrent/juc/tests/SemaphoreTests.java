package org.jingyes.concurrent.juc.tests;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore 示例
 *
 * @author chenjing
 * @date 2020/12/31
 */
public class SemaphoreTests {
    @Test
    public void semaphore_test1() throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("thread 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        });
        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("thread 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        });
        semaphore.acquire(2);
        System.out.println("over");

        executorService.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("thread 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        });
        executorService.submit(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("thread 4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        });
        semaphore.acquire(2);
        System.out.println("over");
    }
}
