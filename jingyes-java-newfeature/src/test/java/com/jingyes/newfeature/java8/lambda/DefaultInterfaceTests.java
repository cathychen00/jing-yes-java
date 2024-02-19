package com.jingyes.newfeature.java8.lambda;


import com.jingyes.newfeature.common.Formula;

/**
 * @author chenjing
 * @date 2021/1/20
 */
public class DefaultInterfaceTests {
    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double caculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.caculate(100));
        System.out.println(formula.sqrt(16));
    }
}
