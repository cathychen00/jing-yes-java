package org.jingyes.designpattern.Structural.bridge.message;

/**
 * @author jingyes
 * @date 2023/12/5
 */
public class CommMessage extends AbstractMessage {
    public CommMessage(MessageSender sender) {
        super(sender);
    }

    @Override
    public void send(String message) {
        super.send("[普通]" + message);
    }
}
