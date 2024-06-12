package org.jingyes.j2se.code01;

import java.math.BigDecimal;

/**
 * @author jingyes
 * @date 17/12/23
 */
public class DoubleDemo {
    public static void main(String[] args) {
        double d1 = 0.05;
        double d2 = 0.01;
        double result = d1 + d2;
        System.out.println(result);//结果：0.060000000000000005

        BigDecimal bd1 = new BigDecimal("0.05");
        BigDecimal bd2 = new BigDecimal(Double.valueOf("0.01"));
        double result2 = bd1.add(bd2).doubleValue();
        System.out.println(result2);//结果：0.06
    }
}