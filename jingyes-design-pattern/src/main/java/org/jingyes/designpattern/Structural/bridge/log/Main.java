package org.jingyes.designpattern.Structural.bridge.log;

/**
 * 桥接模式实现日志示例
 *
 * @author jingyes
 * @date 2023/12/5
 */
public class Main {
    public static void main(String[] args) {
        ErrorLogger errorLogger = new ErrorLogger(new DBLog("db_log"));
        errorLogger.write("global exception", "null exception....");

        InfoLogger infoLogger = new InfoLogger(new FileLog());
        infoLogger.write("同步完成", "同步数据1000条");
    }
}
