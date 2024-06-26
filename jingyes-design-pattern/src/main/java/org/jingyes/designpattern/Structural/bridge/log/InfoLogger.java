package org.jingyes.designpattern.Structural.bridge.log;

/**
 * @author jingyes
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
