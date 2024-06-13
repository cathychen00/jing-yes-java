package org.jingyes.concurrent.juc.thread;

import java.util.concurrent.*;

/**
 * Callable示例，相比Runnable接口有返回参数
 *
 * @author chenjing
 */
public class CallableDemo implements Callable<Integer> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> result = executor.submit(new CallableDemo());
        System.out.println(result.get());
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 100;
    }
}
