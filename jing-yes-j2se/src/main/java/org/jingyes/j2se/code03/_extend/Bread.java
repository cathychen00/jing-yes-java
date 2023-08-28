package org.jingyes.j2se.code03._extend;

/**
 * @author 陈敬
 * @date 18/1/17
 */
public class Bread extends Product {
    private int price;

    public Bread(String name, int price) {
        super(name);
        this.price = price;
    }

    @Override
    public void display() {
        System.out.println("[Bread]getDescription()");
    }
    public void display(String storeName) {
        System.out.println("[Bread]getDescription(String storeName)");
    }
}
