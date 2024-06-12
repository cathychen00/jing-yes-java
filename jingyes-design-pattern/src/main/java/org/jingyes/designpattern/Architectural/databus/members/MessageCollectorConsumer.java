package org.jingyes.designpattern.Architectural.databus.members;

import org.jingyes.designpattern.Architectural.databus.MsgConsumer;
import org.jingyes.designpattern.Architectural.databus.data.DataMessage;
import org.jingyes.designpattern.Architectural.databus.DataType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingyes
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
