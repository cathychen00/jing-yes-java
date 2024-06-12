package com.jingyesjava.spidemo;

/**
 * @author jingyes
 * @date 2024/4/18
 */
public class DbLogger implements Logger {
    @Override
    public void info(String msg) {
        System.out.println("[DB INFO] " + msg);
    }

    @Override
    public void error(String msg) {
        System.out.println("[DB ERROR] " + msg);
    }
}
