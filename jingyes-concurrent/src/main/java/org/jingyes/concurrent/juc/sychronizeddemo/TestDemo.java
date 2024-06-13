package org.jingyes.concurrent.juc.sychronizeddemo;

class TestDemo extends Thread {
    TestDemo(Runnable runnable, String name) {
        super(runnable, name);
    }

    public static void main(String[] args) {
        SynchronizedDemo2 instance1 = new SynchronizedDemo2();
        SynchronizedDemo2 instance2 = new SynchronizedDemo2();

        TestDemo testDemo = new TestDemo(instance1, "Thread1");
        TestDemo testDemo2 = new TestDemo(instance2, "Thread2");

        testDemo.start();
        testDemo2.start();
    }
}
