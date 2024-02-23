package com.jingyes.j2se.tests;

import org.junit.Assert;
import org.junit.Test;

/**
 * Integer
 *
 * @author 陈敬
 * @date 2024/2/20
 */
public class IntegerTests {
    /**
     * 数值比较
     */
    @Test
    public void equals() {
        Integer x = 127;
        Integer y = 127;
        Integer m = 99999;
        Integer n = 99999;
        System.out.println("x == y: " + (x == y));
        System.out.println("m == n: " + (m == n));
        System.out.println("x.equals(y): " + x.equals(y));
        System.out.println("m.equals(n): " + m.equals(n));
        //执行结果
//        x == y: true
//        m == n: false
//        x.equals(y): true
//        m.equals(n): true
    }

    @Test
    public void instance() {
        //每次创建一个新实例
        Integer a1 = new Integer(100);
        Integer a2 = new Integer(100);
        Assert.assertFalse(a1 == a2);
        //add
        Integer a3 = new Integer(200);
        //注意这里喽！！
        // 因为+这个操作符不适用于 Integer 对象，首先 i5 和 i6 进行自动拆箱操作，进行数值相加，即 i4 == 40。
        Assert.assertTrue(a1 + a2 == 200);
        Assert.assertTrue(a1 + a2 == a3);

        //常量池
        Integer b1 = Integer.valueOf(100);
        Integer b2 = Integer.valueOf(100);
        Assert.assertTrue(b1 == b2);
    }
}
