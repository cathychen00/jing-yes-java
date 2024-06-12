package org.jingyes.concurrent.juc.thread;

/**
 * @author chenjing
 * @date 2020/9/4
 */
public class MoreThreadsDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new LiftCounter(10));
            t.start();
        }

        System.out.println("done");
    }
}
