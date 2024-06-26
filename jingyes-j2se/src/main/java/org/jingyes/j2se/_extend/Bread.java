package org.jingyes.j2se._extend;

/**
 * @author jingyes
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
