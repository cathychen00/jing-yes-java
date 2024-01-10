package org.jingyes.designpattern.databus.members;

import org.jingyes.designpattern.databus.DataType;
import org.jingyes.designpattern.databus.MsgConsumer;
import org.jingyes.designpattern.databus.data.DataMessage;
import org.jingyes.designpattern.databus.data.StartMessage;
import org.jingyes.designpattern.databus.data.StopMessage;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author 陈敬
 * @date 2024/1/10
 */
public class StatisticConsumer implements MsgConsumer {
    private LocalDateTime start;
    private LocalDateTime stop;

    @Override
    public void accept(DataType dataType) {
        if (dataType instanceof StartMessage) {
            this.handleEvent((StartMessage) dataType);
        } else if (dataType instanceof StopMessage) {
            this.handleEvent((StopMessage) dataType);
        }
    }

    private void handleEvent(StartMessage message) {
        this.start = message.getWhen();
        message.getDataBus().publish(new DataMessage("开始执行"));
    }

    private void handleEvent(StopMessage message) {
        this.stop = message.getWhen();
        message.getDataBus().publish(new DataMessage("执行完成，耗时"+ Duration.between(start,stop).getSeconds()+"秒"));
    }
}
