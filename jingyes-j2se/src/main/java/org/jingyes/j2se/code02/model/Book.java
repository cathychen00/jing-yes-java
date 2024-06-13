package org.jingyes.j2se.code02.model;

public class Book {
    private int price;

    public void setPrice(int price) {
        this.price = price;
    }

    public Book(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString() + "[price=" + price + "] ";
    }
}
