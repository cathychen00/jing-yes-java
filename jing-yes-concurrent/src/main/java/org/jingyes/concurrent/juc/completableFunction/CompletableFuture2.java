package org.jingyes.concurrent.juc.completableFunction;

import java.util.concurrent.CompletableFuture;

/**
 * 多个CompletableFuture可以串行执行，
 * 例如，定义两个CompletableFuture，第一个CompletableFuture根据证券名称查询证券代码，第二个CompletableFuture根据证券代码查询证券价格
 *
 * @author chenjing
 * @date 2021/4/21
 */
public class CompletableFuture2 {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> queryCode("Halo"));
        CompletableFuture<Double> f2 = f1.thenApplyAsync((code) -> queryPrice(code));
        f2.thenAccept((result) -> {
            System.out.println(result);
        });

        Thread.sleep(2000);
    }

    private static String queryCode(String name) {
        System.out.println("query code....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "100022";
    }

    private static Double queryPrice(String code) {
        System.out.println("query price....");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Math.random() * 100;
    }
}
