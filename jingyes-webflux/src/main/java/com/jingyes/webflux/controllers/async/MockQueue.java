package com.jingyes.webflux.controllers.async;

import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author chenjing
 * @date 2020/11/13
 */
@Component
public class MockQueue {
    /**
     * 接收队列
     */
    private BlockingQueue<Task<String>> receiveQueue = new LinkedBlockingDeque<>(5000);
    /**
     * 结果队列
     */
    private BlockingQueue<Task<String>> resultQueue = new LinkedBlockingDeque<>(5000);

    public MockQueue() {
        this.run();
    }

    /**
     * 接收task
     *
     * @param task task实体
     * @throws InterruptedException
     */
    public void put(Task<String> task) throws InterruptedException {
        receiveQueue.put(task);
    }

    /**
     * 获取结果
     *
     * @return
     * @throws InterruptedException
     */
    public Task<String> get() throws InterruptedException {
        return resultQueue.take();
    }

    private void run() {
        new Thread(() -> {
            while (true) {
                try {
                    Task<String> task = receiveQueue.take();
                    System.out.println("receive data,start process!");
                    Thread.sleep(1000);
                    task.setMessage("success");

                    //任务超时，跳过
                    if (task.getIsTimeout()) {
                        continue;
                    }

                    resultQueue.put(task);
                    System.out.println("process done!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
