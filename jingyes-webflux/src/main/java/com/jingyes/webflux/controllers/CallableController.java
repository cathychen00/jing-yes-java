package com.jingyes.webflux.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author chenjing
 * @date 2020/11/12
 * @remark 接口异步处理，Callable方式
 */
@Controller
public class CallableController {
    @RequestMapping(path = "/async1", method = RequestMethod.GET)
    @ResponseBody
    public Callable<String> asyncRequest() {
        return () -> {
            final long currentThread = Thread.currentThread().getId();
            final Date requestProcessingStarted = new Date();

            Thread.sleep(6000L);

            final Date requestProcessingFinished = new Date();

            return String.format(
                    "request: [threadId: %s, started: %s - finished: %s]"
                    , currentThread, requestProcessingStarted, requestProcessingFinished);
        };
    }
}