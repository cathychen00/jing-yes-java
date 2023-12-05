package org.jingyes.designpattern.bridge.message;

/**
 * @author 陈敬
 * @date 2023/12/5
 */
public class SmsSender implements MessageSender{
    private String phone;

    public SmsSender(String phone) {
        this.phone = phone;
    }

    @Override
    public void send(String msg) {
        System.out.println("发短信"+phone+" "+msg);
    }
}
