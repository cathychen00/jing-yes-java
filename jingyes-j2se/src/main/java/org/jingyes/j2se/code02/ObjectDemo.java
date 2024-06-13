package org.jingyes.j2se.code02;

import org.jingyes.j2se.code02.model.Book;

/**
 * @author jingyes
 * @date 18/1/3
 */
public class ObjectDemo {
    public static void main(String[] args) {
        Book book = new Book(10);
        System.out.println("①" + book.toString());
        change(book);
        System.out.println("③" + book.toString());
    }

    private static void change(Book book) {
        book.setPrice(20);
        System.out.println("②change()" + book);
    }
}

