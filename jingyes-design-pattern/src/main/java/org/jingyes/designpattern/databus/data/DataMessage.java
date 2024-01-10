package org.jingyes.designpattern.databus.data;

import org.jingyes.designpattern.databus.AbstractMessage;

/**
 * @author 陈敬
 * @date 2024/1/9
 */
public class DataMessage extends AbstractMessage {
    private String msg;

    public DataMessage(String msg) {
        this.msg = msg;
    }

    public static DataMessage of(String msg) {
        return new DataMessage(msg);
    }

    public String getMsg() {
        return msg;
    }
}
