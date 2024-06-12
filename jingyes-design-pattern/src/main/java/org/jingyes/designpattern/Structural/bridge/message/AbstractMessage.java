package org.jingyes.designpattern.Structural.bridge.message;

/**
 * @author jingyes
 * @date 2023/12/5
 */
public abstract class AbstractMessage {
    private MessageSender sender;

    public AbstractMessage(MessageSender sender) {
        this.sender = sender;
    }

    public void send(String message) {
        this.sender.send(message);
    }
}
