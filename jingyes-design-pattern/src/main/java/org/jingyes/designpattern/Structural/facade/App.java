package org.jingyes.designpattern.Structural.facade;

/**
 * @author jingyes
 * @date 2024/1/16
 */
public class App {
    public static void main(String[] args) {
        WorkerFacade facade=new WorkerFacade();
        facade.start();
        facade.work();
        facade.end();
    }
}
