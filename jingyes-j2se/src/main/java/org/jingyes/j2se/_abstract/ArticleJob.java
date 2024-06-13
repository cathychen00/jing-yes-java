package org.jingyes.j2se._abstract;

/**
 * @author jingyes
 * @date 18/1/18
 */
public class ArticleJob extends BaseJob {
    @Override
    protected String getDescription() {
        return "抓取文章任务";
    }

    @Override
    protected void execute(String jobId) {
        System.out.println("抓取站点新闻文章 jobid="+jobId);
    }

    public static void main(String[] args) {
        BaseJob articleJob=new ArticleJob();
        articleJob.run();
    }
}
