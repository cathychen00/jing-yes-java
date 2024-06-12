package org.jingyes.concurrent.juc.tests;

import org.junit.Test;

/**
 * @author chenjing
 * @date 2020/12/9
 * join等待线程执行终止
 */
public class JoinTests {
    @Test
    public void join() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 over");
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 over");
        });

        t1.start();
        t2.start();
        //阻塞主线程，等待t1和t2执行完毕后返回。
        t1.join();
        t2.join();
    }

    @Test
    public void join_interrpt() {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 run");
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1");
            }
        });

        Thread tMain = Thread.currentThread();
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                tMain.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 over");
        });

        t1.start();
        t2.start();
        //阻塞主线程，等待t1和t2执行完毕后返回。
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("main thread" + e);
        }
    }
}
