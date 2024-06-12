package org.jingyes.designpattern.Concurrency.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author jingyes
 * @date 2024/1/16
 */
public class ItemQueue {
    private final BlockingQueue<Item> queue;

    public ItemQueue() {
        this.queue = new ArrayBlockingQueue<>(5);
    }

    public void put(Item item) throws InterruptedException {
        this.queue.put(item);
    }

    public Item take() throws InterruptedException {
        return queue.take();
    }
}
