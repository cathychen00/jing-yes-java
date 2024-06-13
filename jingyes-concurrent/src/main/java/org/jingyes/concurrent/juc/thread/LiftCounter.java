package org.jingyes.concurrent.juc.thread;

/**
 * @author chenjing
 * @date 2020/9/4
 */
public class LiftCounter implements Runnable {
    private static Integer taskCount = 0;
    private Integer countDown = 0;
    private Integer id = taskCount++;

    public LiftCounter(Integer countDown) {
        this.countDown = countDown;
    }

    public String getStatus() {
        return "#" + id + "(" + countDown + ")";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(getStatus());
            Thread.yield();
        }
    }
}
