package com.jingyes.newfeature.java11;

/**
 * @author chenjing
 * @date 2021/1/28
 */
public class StringTests {
    public static void main(String[] args) {
        System.out.println(" ".isBlank());
        System.out.println(" test ".strip());
        System.out.println(" test ".stripLeading());
        System.out.println(" test ".stripTrailing());
        System.out.println("test".repeat(3));
        System.out.println("test\ntest\ntest\n".lines().count());
        "test1\ntest1\ntest1\n".lines()
                .forEach(System.out::println);
    }
}
