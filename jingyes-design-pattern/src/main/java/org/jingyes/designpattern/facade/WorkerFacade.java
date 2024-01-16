package org.jingyes.designpattern.facade;

import org.jingyes.designpattern.facade.workers.CartOperatorWorker;
import org.jingyes.designpattern.facade.workers.DiggerWorker;
import org.jingyes.designpattern.facade.workers.TunnelWorker;

import java.util.List;

/**
 * @author 陈敬
 * @date 2024/1/16
 */
public class WorkerFacade {
    private List<AbstractMineWorker> workers;

    public WorkerFacade() {
        workers = List.of(new CartOperatorWorker(), new DiggerWorker(), new TunnelWorker());
    }

    public void start() {
        System.out.println("*****start*****");
        makeActions(this.workers, Action.WAKE_UP);
    }

    public void work() {
        System.out.println("*****work*****");
        makeActions(this.workers, Action.GO_TO_MINE, Action.WORK);
    }

    public void end() {
        System.out.println("*****end*****");
        makeActions(this.workers, Action.GO_HOME, Action.GO_TO_SLEEP);
    }


    private void makeActions(List<AbstractMineWorker> workers, Action... actions) {
        workers.forEach(worker -> worker.actions(actions));
    }
}
