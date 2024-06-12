package com.jingyesjava.spidemo;

/**
 * @author jingyes
 * @date 2024/4/18
 */
public class FileLogger implements Logger {
    @Override
    public void info(String msg) {
        System.out.println("[File INFO] " + msg);
    }

    @Override
    public void error(String msg) {
        System.out.println("[File ERROR] " + msg);
    }
}
