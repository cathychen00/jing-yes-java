package org.jingyes.designpattern.Architectural.databus.data;

import org.jingyes.designpattern.Architectural.databus.AbstractMessage;

import java.time.LocalDateTime;

/**
 * @author 陈敬
 * @date 2024/1/10
 */
public class StopMessage extends AbstractMessage {
    private LocalDateTime when;

    public StopMessage(LocalDateTime when) {
        this.when = when;
    }

    public static StopMessage of(LocalDateTime when) {
        return new StopMessage(when);
    }

    public LocalDateTime getWhen() {
        return when;
    }

    public void setWhen(LocalDateTime when) {
        this.when = when;
    }
}
