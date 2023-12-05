package org.jingyes.designpattern.bridge.log;

/**
 * @author 陈敬
 * @date 2023/12/4
 */
public abstract class Logger {
    private Log log;

    public Logger(Log log) {
        this.log = log;
    }

    public void write(String name, String message) {
        this.log.write(name + "\r\n" + message);
    }
}
