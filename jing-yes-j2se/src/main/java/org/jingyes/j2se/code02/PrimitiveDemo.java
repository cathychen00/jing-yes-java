package org.jingyes.j2se.code02;

/**
 * @author 陈敬
 * @date 18/1/3
 * 测试基本类型传参
 */
public class PrimitiveDemo {
    public static void main(String[] args) {
        int num = 10;
        change(num);
        System.out.println("main() a=" + num);//10
    }

    private static void change(Integer a) {
        System.out.println("1 change() a=" + a);//10
        a = 20;
        System.out.println("2 change() a=" + a);//20
    }
}
