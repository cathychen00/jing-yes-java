package com.jingyes.j2se.tests.reflect;

/**
 * @author chenjing
 * @date 2020/12/8
 */
public class HelloImpl implements Hello {
    @Override
    public void morning(String name) {
        System.out.println("HelloImpl.morning");
    }

    @Override
    public void after(String name) {
        System.out.println("HelloImpl.after");
    }
}
