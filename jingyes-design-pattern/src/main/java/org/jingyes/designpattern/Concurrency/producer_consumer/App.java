package org.jingyes.designpattern.Concurrency.producer_consumer;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jingyes
 * @date 2024/1/16
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        var queue = new ItemQueue();

        var executorService = Executors.newFixedThreadPool(5);
        for (var i = 0; i < 2; i++) {

            final var producer = new Producer("writer_" + i, queue);
            executorService.submit(() -> {
                while (true) {
                    producer.produce();
                }
            });
        }

        for (var i = 0; i < 3; i++) {
            final var consumer = new Consumer("reader_" + i, queue);
            executorService.submit(() -> {
                while (true) {
                    consumer.consume();
                }
            });
        }

        executorService.shutdown();

        executorService.awaitTermination(3, TimeUnit.SECONDS);
        executorService.shutdownNow();
    }
}
