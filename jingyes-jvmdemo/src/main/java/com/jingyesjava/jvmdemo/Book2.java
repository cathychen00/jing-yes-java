package com.jingyesjava.jvmdemo;

/**
 * JVM 加载过程的例子
 *
 * @author jingyes
 * @date 2021/1/7
 */
public class Book2 {
    static Book2 book = new Book2();
    static int amount = 112;

    static {
        System.out.println("Book2 的静态代码块");
    }

    int price = 110;

    {
        System.out.println("Book2的普通代码块");
    }

    Book2() {
        System.out.println("Book2的构造方法");
        System.out.println("price=" + price + ",amount=" + amount);
    }

    public static void main(String[] args) {
        staticFunction();
    }

    public static void staticFunction() {
        System.out.println("Book2 的静态方法");
        System.out.println("amount=" + amount);
    }
}