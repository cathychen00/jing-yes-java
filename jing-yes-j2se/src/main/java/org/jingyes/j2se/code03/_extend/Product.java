package org.jingyes.j2se.code03._extend;

/**
 * @author jingyes
 * @date 18/1/17
 */
public class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("[Product]getDescription()");
    }
}
