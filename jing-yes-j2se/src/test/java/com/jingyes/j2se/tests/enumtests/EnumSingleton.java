package com.jingyes.j2se.tests.enumtests;

/**
 * 枚举实现单例模式
 *
 * @author 陈敬
 * @date 2023/11/30
 */
public enum EnumSingleton {
    INSTANCE;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
