package org.jingyes.designpattern.databus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈敬
 * @date 2024/1/9
 */
public class DataBus {
    private static DataBus INSTANCE = new DataBus();

    public static DataBus getINSTANCE() {
        return INSTANCE;
    }

    private List<MsgConsumer> listeners=new ArrayList<>();

    public void subscribe(MsgConsumer member) {
        this.listeners.add(member);
    }

    public void unSubscribe(MsgConsumer member) {
        this.listeners.remove(member);
    }

    public void publish(DataType dataType) {
        dataType.setDataBus(this);
        this.listeners.forEach(x -> x.accept(dataType));
    }
}
