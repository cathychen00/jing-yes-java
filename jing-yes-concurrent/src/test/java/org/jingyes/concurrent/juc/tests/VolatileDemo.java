package org.jingyes.concurrent.juc.tests;

/**
 * volatile语义：
 * 1.内存可见性：一个线程修改共享变量时，另外一个线程可以读取到修改后的值
 * 2.禁止重排序：禁止volatile变量和普通变量重排序
 *
 * @author chenjing
 */
public class VolatileDemo {
    //关键字volatile，保证一个线程改变变量值时，其他线程可见
    private static volatile int signal = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(1);
        new Thread(new ThreadB()).start();
    }

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            while (signal < 5) {
                if (signal % 2 == 0) {
                    System.out.println("threadA: " + signal);
                    increase();
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            while (signal < 5) {
                if (signal % 2 == 1) {
                    System.out.println("threadB: " + signal);
                    increase();
                }
            }
        }
    }

    /**
     * 注意：volatile 能保证变量的内存可见性，但是不能保证操作的原子性
     */
    private synchronized static void increase() {
        signal++;
    }
}
