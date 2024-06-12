package org.jingyes.concurrent.juc.thread;

import java.util.concurrent.*;

/**
 * FutureTask示例
 *
 * @author chenjing
 */
public class FutureTaskDemo implements Callable<Integer> {

    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new FutureTaskDemo());
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(futureTask);
        //FutureTask是实现的RunnableFuture接口的，而RunnableFuture接口同时继承了Runnable接口和Future接口
        //具有cancel, isCancelled等方法
//        futureTask.cancel(true);
        System.out.println(futureTask.isCancelled());
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(futureTask.isDone());
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 100;
    }
}
