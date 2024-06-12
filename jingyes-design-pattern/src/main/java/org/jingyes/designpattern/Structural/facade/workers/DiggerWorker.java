package org.jingyes.designpattern.Structural.facade.workers;

import org.jingyes.designpattern.Structural.facade.AbstractMineWorker;

/**
 * @author jingyes
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
