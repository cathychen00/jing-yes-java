package org.jingyes.designpattern.Concurrency.producer_consumer;

/**
 * @author 陈敬
 * @date 2024/1/16
 */
public class Item {
    private Integer id;
    private String producerName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Item(Integer id, String producerName) {
        this.id = id;
        this.producerName = producerName;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }
}
