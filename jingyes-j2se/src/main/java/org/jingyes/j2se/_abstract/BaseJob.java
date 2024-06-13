package org.jingyes.j2se._abstract;

/**
 * @author jingyes
 * @date 18/1/18
 */
public abstract class BaseJob {
    public void run(){
        System.out.println("==START "+getDescription()+"==");
        String lastJobId=getLastJobId();
        execute(lastJobId);
        writeLog();
        System.out.println("==END "+getDescription()+"==");
    }

    protected abstract String getDescription();

    protected abstract void execute(String jobId);

    private void writeLog() {
        System.out.println("write log to DB");
    }

    private String getLastJobId() {
        return "job1221";
    }
}
