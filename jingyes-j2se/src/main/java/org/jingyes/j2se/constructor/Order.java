package org.jingyes.j2se.constructor;

/**
 * 构造函数执行顺序，先初始化变量，再执行构造函数
 *
 * @author jingyes
 * @date 18/1/3
 */
public class Order {
    OrderDetail d1 = new OrderDetail(100);
    OrderDetail d2 = new OrderDetail(200);

    public Order() {
        OrderDetail d3 = new OrderDetail(300);
    }

    OrderDetail d4 = new OrderDetail(400);

    public static void main(String[] args) {
        new Order();
    }
}

class OrderDetail {
    public OrderDetail(Integer price) {
        System.out.println("OrderDetail price=" + price);
    }
}
