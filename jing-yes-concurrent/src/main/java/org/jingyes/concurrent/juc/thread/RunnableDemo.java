package org.jingyes.concurrent.juc.thread;

/**
 * @author 陈敬
 * @date 18/2/2
 */
public class RunnableDemo {
    public static void main(String[] args) {
        for (int id = 0; id < 5; id++) {
            startJob("job" + id);
        }
    }

    private static void startJob(final String jobid) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                new job("job" + jobid, 20).execute();
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
}

class job {
    private String jobid;
    private Integer num;

    public job(String id, Integer num) {
        this.jobid = id;
        this.num = num;
    }

    public void execute() {
        for (int i = 0; i < num; i++) {
            System.out.println(jobid + ".execute() " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(jobid + " DONE ");
    }
}
