package com.jingyes.webflux.controllers.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author chenjing
 * @date 2020/11/27
 * @remark 监听器，将结果队列赋值给DeferredResult
 */
@Component
public class QueueResultListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    MockQueue mockQueue;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(() -> {
            try {
                Task<String> task = mockQueue.get();
                task.getResult().setResult(task.getMessage());
                System.out.println("监听器获取到结果：task=" + task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
