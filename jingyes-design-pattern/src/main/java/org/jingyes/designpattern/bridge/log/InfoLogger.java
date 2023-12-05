package org.jingyes.designpattern.bridge.log;

/**
 * @author 陈敬
 * @date 2023/12/4
 */
public class InfoLogger extends Logger {
    public InfoLogger(Log log) {
        super(log);
    }

    @Override
    public void write(String name, String message) {
        super.write("[Info] " + name, message);
    }
}
