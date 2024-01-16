package org.jingyes.designpattern.Structural.bridge.message;

/**
 * 用桥接模式实现消息示例
 * @author 陈敬
 * @date 2023/12/5
 */
public class Main {
    public static void main(String[] args) {
        AbstractMessage commonSmsMsg=new CommMessage(new SmsSender("15900000000"));
        commonSmsMsg.send("欢迎关注 敬YES");
        AbstractMessage commonDingMsg=new CommMessage(new DingdingSender(999));
        commonDingMsg.send("欢迎关注 敬YES");

        AbstractMessage urgencySmsMsg=new UrgencyMessage(new SmsSender("15900000000"));
        urgencySmsMsg.send("您有3条待办事项，请及时处理");
        AbstractMessage urgencyDingMsg=new UrgencyMessage(new DingdingSender(999));
        urgencyDingMsg.send("您有3条待办事项，请及时处理");
    }
}
