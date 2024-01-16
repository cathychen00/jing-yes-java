package org.jingyes.designpattern.Structural.bridge.log;

/**
 * @author 陈敬
 * @date 2023/12/4
 */
public class ErrorLogger extends Logger {
    public ErrorLogger(Log log) {
        super(log);
    }

    @Override
    public void write(String name, String message) {
        super.write("[Error] " + name, message);
    }
}
