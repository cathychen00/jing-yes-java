package com.jingyes.newfeature.common;

/**
 * @author jingyes
 * @date 2021/1/20
 */
public interface Formula {
    double caculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
