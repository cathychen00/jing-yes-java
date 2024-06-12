package org.jingyes.designpattern.Structural.facade.workers;

import org.jingyes.designpattern.Structural.facade.AbstractMineWorker;

/**
 * @author jingyes
 * @date 2024/1/16
 */
public class CartOperatorWorker extends AbstractMineWorker {
    @Override
    public String name() {
        return "CartOperator";
    }

    @Override
    public void work() {
        System.out.println(name()+" move out of mine");
    }
}
