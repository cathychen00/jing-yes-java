package com.jingyes.webflux.controllers.async;

import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author chenjing
 * @date 2020/11/13
 */
public class Task<T> {
    private DeferredResult<String> result;
    private T message;
    private Boolean isTimeout;

    public Task(DeferredResult<String> result, T message, Boolean isTimeout) {
        this.message = message;
        this.result = result;
        this.isTimeout = isTimeout;
    }

    public Task() {
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public DeferredResult<String> getResult() {
        return result;
    }

    public void setResult(DeferredResult<String> result) {
        this.result = result;
    }

    public Boolean getIsTimeout() {
        return isTimeout;
    }

    public void setIsTimeout(Boolean timeout) {
        isTimeout = timeout;
    }

    @Override
    public String toString() {
        return "Task{" +
                "message=" + message +
                ", result=" + result +
                ", isTimeout=" + isTimeout +
                '}';
    }
}
