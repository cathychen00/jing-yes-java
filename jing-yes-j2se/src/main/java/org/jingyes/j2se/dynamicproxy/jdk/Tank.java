package org.jingyes.j2se.dynamicproxy.jdk;

/**
 * @author chenjing
 * @date 2020/12/1
 */
public final class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("tank is moving...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
