package com.jingyes.j2se.tests;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author jingyes
 * @date 2024/2/20
 */
public class BigDecimalTests {
    /**
     * 保留几位小数
     */
    @Test
    public void setScale() {
        BigDecimal a = new BigDecimal("1.23455");
        System.out.println(a.toString());//1.23456
        //BigDecimal保留几位小数
        System.out.println(a.setScale(3, RoundingMode.HALF_DOWN));//1.235
        System.out.println(a.setScale(3, RoundingMode.HALF_EVEN).toString());//1.235
        System.out.println(a.setScale(4, RoundingMode.HALF_DOWN));//1.2345
        System.out.println(a.setScale(4, RoundingMode.HALF_EVEN).toString());//1.2346
    }

    /**
     * double转换为BigDecimal
     * 阿里规约：禁止使用 new BigDecimal(double d)构造函数创建BigDecimal对象，存在精度丢失风险
     */
    @Test
    public void double2decimal() {
        Double d = 0.1d;
        System.out.println(new BigDecimal(d));//0.1000000000000000055511151231257827021181583404541015625
        System.out.println(new BigDecimal(d.toString()));//0.1
        System.out.println(BigDecimal.valueOf(d));//0.1
    }

    /**
     * BigDecimal等值比较
     * equals:既比较数值，又比较精度；
     * compareTo:仅比较数值
     */
    @Test
    public void compare() {
        BigDecimal a = BigDecimal.valueOf(1);
        BigDecimal b = BigDecimal.valueOf(1.00);
        Assert.assertFalse(a.equals(b));
        Assert.assertEquals(0, a.compareTo(b));
    }

    /**
     * BigDecimal.divide()，除法运算注意要设置精度，否则除不尽的情况会抛异常
     */
    @Test
    public void divide(){
        BigDecimal a=BigDecimal.valueOf(1);
        BigDecimal b=BigDecimal.valueOf(3);
        //直接抛异常
//        System.out.println(a.divide(b));
        //正常返回 0.3333
        System.out.println(a.divide(b,4,RoundingMode.HALF_EVEN));
    }
}
