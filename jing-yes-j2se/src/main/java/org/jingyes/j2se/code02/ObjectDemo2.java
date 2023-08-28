package org.jingyes.j2se.code02;

import org.jingyes.j2se.code02.model.Book;

/**
 * @author 陈敬
 * @date 18/1/3
 */
public class ObjectDemo2 {
    public static void main(String[] args) {
        Book b1=new Book(10);
        Book b2=new Book(20);
        System.out.println("before swap" + b1 + b2);
        swap(b1,b2);
        System.out.println("after swap" + b1 + b2);
    }

    private static void swap(Book pb1, Book pb2) {
        //此时pb1和b1指向book[price=10],pb2和b2指向book[price=20]
        Book temp = pb1;
        pb1 = pb2;
        pb2 = temp;
        //pb1和pb2交换了指向的对象
        System.out.println("swap() pb1 " + pb1);
        System.out.println("swap() pb2 " + pb2);
        //修改pb1，即b2指向的对象
        pb1.setPrice(100);
        //修改pb2，即b1指向的对象
        pb2.setPrice(200);
    }
}

