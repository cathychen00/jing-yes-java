package org.jingyes.concurrent.juc.threadlocal;

/**
 * @author chenjing
 * @date 2021/4/9
 */
public class InheritableThreadLocalDemo {
    public static void main(String[] args) {
        //ThreadLocal不支持继承，使用这种方式child thread获取不到
//        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        //使用这种方式child thread可以获取到
        ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

        threadLocal.set("test");
        Thread childThread = new Thread(() -> {
            System.out.println("child thread:" + threadLocal.get());
        });
        childThread.start();
        System.out.println("main thread:" + threadLocal.get());
        threadLocal.remove();
    }
}
