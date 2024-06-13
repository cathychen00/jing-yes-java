package com.jingyes.webflux.controllers;

import com.jingyes.webflux.controllers.async.MockQueue;
import com.jingyes.webflux.controllers.async.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author chenjing
 * @date 2020/11/12
 * @remark 接口异步处理，DeferredResult，队列
 */
@Controller
public class DeferredResultQueueController {
    @Autowired
    MockQueue queue;

    @ResponseBody
    @GetMapping("/test")
    public DeferredResult<String> test(@RequestParam Integer id) throws InterruptedException {
        System.out.println("start test");
        DeferredResult<String> deferredResult = new DeferredResult<>();
        Task<String> task = new Task<>(deferredResult, "任务", false);
        deferredResult.onTimeout(() -> {
            System.out.println("任务超时 id=" + id);
            task.setMessage("任务超时");
            task.setIsTimeout(true);
        });
        queue.put(task);
        return deferredResult;
    }
}