package org.jingyes.j2se._abstract;

public class AbstractMain {
    public static void main(String[] args) {
        articleJob();
        videoJob();
    }

    public static void articleJob() {
        BaseJob articleJob = new ArticleJob();
        articleJob.run();
    }

    public static void videoJob() {
        BaseJob videoJob = new VideoJob();
        videoJob.run();
    }
}
