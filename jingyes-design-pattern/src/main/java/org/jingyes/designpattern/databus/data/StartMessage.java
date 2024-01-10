package org.jingyes.designpattern.databus.data;

import org.jingyes.designpattern.databus.AbstractMessage;

import java.time.LocalDateTime;

/**
 * @author 陈敬
 * @date 2024/1/10
 */
public class StartMessage extends AbstractMessage {
    private LocalDateTime when;

    public StartMessage(LocalDateTime when) {
        this.when = when;
    }

    public static StartMessage of(LocalDateTime when) {
        return new StartMessage(when);
    }

    public LocalDateTime getWhen() {
        return when;
    }

    public void setWhen(LocalDateTime when) {
        this.when = when;
    }
}
