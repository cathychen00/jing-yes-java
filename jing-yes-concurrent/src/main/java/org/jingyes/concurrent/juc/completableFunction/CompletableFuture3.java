package org.jingyes.concurrent.juc.completableFunction;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture 更复杂的并行串行示例
 *
 * @author chenjing
 * @date 2021/4/21
 */
public class CompletableFuture3 {
    public static void main(String[] args) {
        CompletableFuture<String> queryCode1 = CompletableFuture.supplyAsync(() -> {
            return queryCode("Hello", "http://www.sina.com");
        });
        CompletableFuture<String> queryCode2 = CompletableFuture.supplyAsync(() -> {
            return queryCode("Hello", "http://www.163.com");
        });
        CompletableFuture<Object> queryCode = CompletableFuture.anyOf(queryCode1, queryCode2);

        CompletableFuture<Double> queryPrice1 = queryCode.thenApplyAsync((code) -> {
            return queryPrice((String) code, "http://www.sina.com");
        });
        CompletableFuture<Double> queryPrice2 = queryCode.thenApplyAsync((code) -> {
            return queryPrice((String) code, "http://www.163.com");
        });
        CompletableFuture<Void> queryPrice = CompletableFuture.allOf(queryPrice1, queryPrice2);

        queryPrice.thenAccept((price) -> {
            System.out.println(price);
        });
        queryPrice.exceptionally(ex -> {
            ex.printStackTrace();
            return null;
        });

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String queryCode(String name, String url) {
        System.out.println("query code from url " + url);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "100022";
    }

    private static Double queryPrice(String code, String url) {
        System.out.println("query price from url " + url);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Math.random() * 100;
    }
}
