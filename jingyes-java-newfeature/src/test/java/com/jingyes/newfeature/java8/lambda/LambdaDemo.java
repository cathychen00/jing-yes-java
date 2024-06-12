package com.jingyes.newfeature.java8.lambda;

/**
 * Lambda示例
 *
 * @author jingyes
 * @date 2024/1/3
 */
public class LambdaDemo {
    public static void main(String[] args) {
        MathOperation add = (a, b) -> a + b;
        MathOperation sub = (a, b) -> a - b;

        System.out.println(operate(10, 5, add));
        System.out.println(operate(10, 5, sub));
    }

    private static int operate(int a, int b, MathOperation operation) {
        return operation.operate(a, b);
    }
}
