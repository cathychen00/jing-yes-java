package org.jingyes.j2se.code03._abstract;

/**
 * @author jingyes
 * @date 18/1/18
 */
public class VideoJob extends BaseJob {
    @Override
    protected String getDescription() {
        return "抓取视频任务";
    }

    @Override
    protected void execute(String jobId) {
        System.out.println("抓取站点短视频 jobid="+jobId);
    }
}
