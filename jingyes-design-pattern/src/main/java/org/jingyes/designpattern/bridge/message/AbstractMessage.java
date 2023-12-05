package org.jingyes.designpattern.bridge.message;

/**
 * @author 陈敬
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
