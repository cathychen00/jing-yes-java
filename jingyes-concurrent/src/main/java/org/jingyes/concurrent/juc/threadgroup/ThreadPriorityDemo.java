package org.jingyes.concurrent.juc.threadgroup;

/**
 * 一个线程必然存在于一个线程组中，那么当线程和线程组的优先级不一致的时候将会怎样呢
 *
 * @author chenjing
 */
public class ThreadPriorityDemo {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("g1");
        //线程组优先级6
        group.setMaxPriority(6);

        Thread t = new Thread(group, "t1");
        //线程优先级
        t.setPriority(8);
        t.start();

//        结论：如果某个线程优先级大于线程所在线程组的最大优先级，那么该线程的优先级将会失效
        System.out.println(group.getMaxPriority());//6
        System.out.println(t.getPriority());//6
    }
}
