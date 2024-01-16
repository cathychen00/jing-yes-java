package org.jingyes.designpattern.Structural.bridge.message;

/**
 * @author 陈敬
 * @date 2023/12/5
 */
public class DingdingSender implements MessageSender {
    private Integer employId;

    public DingdingSender(Integer employId) {
        this.employId = employId;
    }

    @Override
    public void send(String msg) {
        System.out.println("发钉钉提醒" + employId + " " + msg);
    }
}
