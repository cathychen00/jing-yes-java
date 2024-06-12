package org.jingyes.concurrent.juc;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 陈敬
 * @date 2018/4/4
 * exception test
 */
public class ScheduledExecutor2Test {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        long initialDelay1 = 1;
        long period1 = 1;
        // 从现在开始1秒钟之后，每隔1秒钟执行一次job1
        service.scheduleAtFixedRate(
                new JobA(), 1,
                period1, TimeUnit.SECONDS);

        long initialDelay2 = 1;
        long delay2 = 1;
        // 从现在开始2秒钟之后，每隔2秒钟执行一次job2
        service.scheduleWithFixedDelay(
                new JobB(), 5,
                delay2, TimeUnit.SECONDS);
    }
}
class JobA implements Runnable{

    @Override
    public void run() {
        System.out.println("execute A");
//        throw new RuntimeException("aa");

    }
}

class JobB implements Runnable{

    @Override
    public void run() {
        System.out.println("execute B");
        throw new RuntimeException("bb");
    }
}

