package org.jingyes.designpattern.Structural.bridge.log;

/**
 * @author 陈敬
 * @date 2023/12/4
 */
public class DBLog implements Log {
    private String dbName;

    public DBLog(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public void write(String message) {
        System.out.println("*************数据库日志*************\r\n" + this.dbName + ">" + message);
    }
}
