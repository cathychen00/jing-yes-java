package org.jingyes.designpattern.Concurrency.producer_consumer;

/**
 * @author 陈敬
 * @date 2024/1/16
 */
public class Consumer {
    private String name;
    private ItemQueue queue;

    public Consumer(String name,ItemQueue queue) {
        this.name=name;
        this.queue = queue;
    }

    public Item consume() throws InterruptedException {
        Item take = this.queue.take();
        System.out.println("[消费者"+this.name+"]消费 item id="+take.getId()+" 生产者是 "+take.getProducerName());
        return take;
    }
}
