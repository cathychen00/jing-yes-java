package org.jingyes.concurrent.juc.threadlocal;

/**
 * @author chenjing
 * @date 2020/9/8
 */
public class ThreadLocalDemo {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            threadLocal.set("aaa");
            print("t1");
            System.out.println("t1 remove " + threadLocal.get());
        });

        Thread t2 = new Thread(() -> {
            threadLocal.set("aaa");
            print("t2");
            System.out.println("t2 remove " + threadLocal.get());
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    private static void print(String tname) {
        System.out.println(tname + threadLocal.get());

        //注释这里对比效果
        threadLocal.remove();
    }

}
