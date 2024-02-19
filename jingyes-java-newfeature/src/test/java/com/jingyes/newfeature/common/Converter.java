package com.jingyes.newfeature.common;

/**
 * @author chenjing
 * @date 2021/1/21
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F f);
}
