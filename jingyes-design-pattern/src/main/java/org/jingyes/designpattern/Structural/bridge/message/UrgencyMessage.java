package org.jingyes.designpattern.Structural.bridge.message;

/**
 * @author 陈敬
 * @date 2023/12/5
 */
public class UrgencyMessage extends AbstractMessage {
    public UrgencyMessage(MessageSender sender) {
        super(sender);
    }

    @Override
    public void send(String message) {
        super.send("[紧急]" + message);
    }
}
