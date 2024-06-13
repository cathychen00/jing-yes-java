package com.jingyes.webflux.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenjing
 * @date 2020/11/12
 * @remark 接口异步处理，DeferredResult方式
 */
@Controller
public class DeferredResultController {
    private Map<Integer, DeferredResult<String>> deferredResultMap = new HashMap<>();

    @ResponseBody
    @GetMapping("/get")
    public DeferredResult<String> getId(@RequestParam Integer id) throws Exception {
        System.out.println("start hello");
        DeferredResult<String> deferredResult = new DeferredResult<>();

        //先存起来，等待触发
        deferredResultMap.put(id, deferredResult);
        System.out.println("end hello");
        return deferredResult;
    }

    @ResponseBody
    @GetMapping("/set")
    public void setId(@RequestParam Integer id) throws Exception {
        // 让所有hold住的请求给与响应
        if (deferredResultMap.containsKey(id)) {
            deferredResultMap.get(id).setResult("hello " + id);
        }
    }
}