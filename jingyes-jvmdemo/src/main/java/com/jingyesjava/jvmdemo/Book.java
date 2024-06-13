package com.jingyesjava.jvmdemo;

/**
 * JVM 加载过程的例子
 *
 * @author jingyes
 * @date 2021/1/7
 */
public class Book {
    static int amount = 112;

    static {
        System.out.println("Book 的静态代码块");
    }

    int price = 110;

    {
        System.out.println("Book 的普通代码块");
    }

    Book() {
        System.out.println("Book 的构造方法");
        System.out.println("price=" + price + ",amount=" + amount);
    }

    public static void main(String[] args) {
        System.out.println("Hello JingYes.");
//        new Book();
    }
}
