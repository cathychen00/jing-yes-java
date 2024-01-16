package org.jingyes.designpattern.facade;

import java.util.Arrays;

/**
 * @author 陈敬
 * @date 2024/1/16
 */
public abstract class AbstractMineWorker {
    public void wakeup() {
        System.out.println(name() + " wake up");
    }

    public abstract String name();

    private void action(Action action) {
        switch (action) {
            case WAKE_UP -> wakeup();
            case WORK -> work();
            case GO_TO_MINE -> mine();
            case GO_HOME -> gohome();
            case GO_TO_SLEEP -> sleep();
        }
    }

    public void sleep() {
        System.out.println(name() + " sleep ");
    }

    private void gohome() {
        System.out.println(name() + " go home ");
    }

    public void mine() {
        System.out.println(name() + " mine ");
    }

    public abstract void work();

    public void actions(Action... actions) {
        Arrays.asList(actions).forEach(x -> this.action(x));
    }
}
