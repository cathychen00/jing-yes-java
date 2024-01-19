package org.jingyes.designpattern.Concurrency.producer_consumer;

/**
 * @author 陈敬
 * @date 2024/1/16
 */
public class Producer {
    private String name;
    private ItemQueue queue;

    private static int id = 0;

    public Producer(String name, ItemQueue queue) {
        this.name = name;
        this.queue = queue;
    }

    public void produce() throws InterruptedException {
        Item item = new Item(id++, this.name);
        Thread.sleep(100);
        this.queue.put(item);
        System.out.println("[生产者" + this.name + "]生产产品" + item.getId());
    }
}
