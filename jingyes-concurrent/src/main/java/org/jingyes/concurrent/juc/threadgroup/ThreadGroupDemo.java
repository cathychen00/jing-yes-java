package org.jingyes.concurrent.juc.threadgroup;

/**
 * 每个Thread必然存在于一个ThreadGroup中，Thread不能独立于ThreadGroup存在
 *
 * @author chenjing
 */
public class ThreadGroupDemo {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("线程启动");
            // 执行main()方法线程的名字是main，如果在new Thread时没有显式指定，那么默认将父线程（当前执行new Thread的线程）线程组设置为自己的线程组。
            System.out.println("t线程组名字" + Thread.currentThread().getThreadGroup().getName() + " 线程名字" + Thread.currentThread().getName());
        });
        t.start();
        System.out.println("主 线程组名字" + Thread.currentThread().getThreadGroup().getName() + " 线程名字" + Thread.currentThread().getName());
    }
}
