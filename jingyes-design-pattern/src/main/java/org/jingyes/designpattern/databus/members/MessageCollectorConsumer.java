package org.jingyes.designpattern.databus.members;

import org.jingyes.designpattern.databus.DataType;
import org.jingyes.designpattern.databus.MsgConsumer;
import org.jingyes.designpattern.databus.data.DataMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈敬
 * @date 2024/1/9
 */
public class MessageCollectorConsumer implements MsgConsumer {
    private List<String> list = new ArrayList<>();
    private String name;

    public MessageCollectorConsumer(String name) {
        this.name = name;
    }

    @Override
    public void accept(DataType dataType) {
        if (dataType instanceof DataMessage) {
            handleEvent((DataMessage) dataType);
        }
    }

    private void handleEvent(DataMessage messageData) {
        this.list.add(messageData.getMsg());
        System.out.println("[" + name + "]收消息：" + messageData.getMsg());
    }
}
