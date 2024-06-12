package org.jingyes.concurrent.juc.tests;

import org.junit.Test;

/**
 * @author chenjing
 * @date 2020/12/9
 * yield让出CPU使用权
 */
public class YieldTests {
    @Test
    public void yield1() {
        new YieldThread();
        new YieldThread();
        new YieldThread();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class YieldThread implements Runnable {
        public YieldThread() {
            Thread t = new Thread(this);
            t.start();
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 5; i++) {
                if (i % 5 == 0) {
                    System.out.println(Thread.currentThread() + " yield");
//                    Thread.yield();
                }
            }
            System.out.println(Thread.currentThread() + " is over");
        }
    }
}
