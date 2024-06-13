package org.jingyes.j2se.dynamicproxy.cglib;

/**
 * @author chenjing
 * @date 2020/12/1
 */
public class Tank {
    public void move() {
        System.out.println("tank is moving...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
