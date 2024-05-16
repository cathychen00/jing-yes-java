package org.jingyes.concurrent.juc.tests;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier 回环屏障，它可以让一组线程全部达到一个状态后再全部同时执行，特别适合分段任务有序执行的场景
 *
 * @author chenjing
 * @date 2020/12/30
 */
public class CyclicBarrierTests {
    @Test
    public void test_cyclicBarrier1() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            //当几个线程都执行完毕后，会选择一个线程执行这里
            System.out.println("cyclicBarrier run");
        });

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            System.out.println("before thread1 cyclibarrier await");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("after thread1 cyclicBarrier await");
        });

        executorService.submit(() -> {
            System.out.println("before thread2 cyclibarrier await");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("after thread2 cyclicBarrier await");
        });

        executorService.shutdown();
    }
}
