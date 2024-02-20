package com.jingyes.newfeature.java8.optional;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * Optional提供默认值
 *
 * @author 陈敬
 * @date 2024/2/19
 */
public class OptionalDefaultDemo {
    /**
     * orElse提供一个默认值
     */
    @Test
    public void orElse() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse(getMyDefault());
        Assert.assertEquals("Hello jingyes", name);
    }

    /**
     * orElseGet提供一个默认方法
     */
    @Test
    public void orElseGet() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(this::getMyDefault);
        Assert.assertEquals("Hello jingyes", name);
    }

    public String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Hello jingyes";
    }

    /**
     * 抛出异常
     */
    @Test(expected = IllegalArgumentException.class)
    public void orElseThrow() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseThrow(
                IllegalArgumentException::new);
    }
}
