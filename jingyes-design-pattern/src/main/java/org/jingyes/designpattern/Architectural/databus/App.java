package org.jingyes.designpattern.Architectural.databus;

import org.jingyes.designpattern.Architectural.databus.data.DataMessage;
import org.jingyes.designpattern.Architectural.databus.data.StopMessage;
import org.jingyes.designpattern.Architectural.databus.members.StatisticConsumer;
import org.jingyes.designpattern.Architectural.databus.data.StartMessage;
import org.jingyes.designpattern.Architectural.databus.members.MessageCollectorConsumer;

import java.time.LocalDateTime;

/**
 * data-bus模式，可以支持多对多通信，消费消息的组件自行决定处理的类型，并能多对多通信
 *
 * @author 陈敬
 * @date 2024/1/9
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        DataBus bus = DataBus.getINSTANCE();
        bus.subscribe(new StatisticConsumer());
        bus.subscribe(new MessageCollectorConsumer("收集器1"));
        bus.publish(new StartMessage(LocalDateTime.now()));
        bus.publish(new DataMessage("测试消息1"));
        System.out.println("**********");
        Thread.sleep(3000L);
        bus.subscribe(new MessageCollectorConsumer("收集器2"));
        bus.publish(new StopMessage(LocalDateTime.now()));
    }
}
