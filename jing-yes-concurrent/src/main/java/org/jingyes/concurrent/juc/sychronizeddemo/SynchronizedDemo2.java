package org.jingyes.concurrent.juc.sychronizeddemo;

/**
 * 测试synchronized锁几种情况
 * https://cloud.tencent.com/developer/article/1767595
 */
public class SynchronizedDemo2 implements Runnable {
    public Integer y = 0;
    public Integer x = new Integer(1);
    public Integer z = 200;
    public Integer k = 100;

    public void setNumber() {
        y++;
    }

    public int getNumber() {
        return y;
    }

    @Override
    public void run() {
        synchronized (SynchronizedDemo2.class) { //能
//        synchronized (this) { //不能
//        synchronized (x) {  //不能，x 在堆， 1 在常量池，两个对象拥有的x 不一样，可以进入
//        synchronized (z) {  //不能 //-128-127 之间，还是同一个对象，否则会Intger创建一个新对象
//        synchronized (k) { //能，x 此时在常量池，常量池是线程共享的，
            for (int i = 1; i <= 5; i++) {
                setNumber();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " : " + i + "  --->>> " + getNumber());
            }
        }
    }
}

