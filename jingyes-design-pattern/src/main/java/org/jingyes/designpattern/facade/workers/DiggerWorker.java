package org.jingyes.designpattern.facade.workers;

import org.jingyes.designpattern.facade.AbstractMineWorker;

/**
 * @author 陈敬
 * @date 2024/1/16
 */
public class DiggerWorker extends AbstractMineWorker {
    @Override
    public String name() {
        return "Digger";
    }

    @Override
    public void work() {
        System.out.println(name()+" dig mine");
    }
}
