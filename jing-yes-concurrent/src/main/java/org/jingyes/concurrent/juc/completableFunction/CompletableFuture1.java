package org.jingyes.concurrent.juc.completableFunction;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture异步回调
 *
 * @author chenjing
 * @date 2021/4/21
 */
public class CompletableFuture1 {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Double> completableFuture = CompletableFuture.supplyAsync(CompletableFuture1::fetchPrice);
        completableFuture.thenAccept(price -> System.out.println(price));
        completableFuture.exceptionally(ex -> {
            ex.printStackTrace();
            return null;
        });

        Thread.sleep(200);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}
