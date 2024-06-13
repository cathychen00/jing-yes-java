package org.jingyes.concurrent.juc.thread;

/**
 * @author chenjing
 * @date 2020/9/4
 */
public class BaseThreadDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftCounter(5));
        t.start();

        System.out.println("done");
    }
}
