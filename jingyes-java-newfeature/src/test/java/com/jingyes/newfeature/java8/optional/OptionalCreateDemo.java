package com.jingyes.newfeature.java8.optional;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * 创建optional对象
 *
 * @author jingyes
 * @date 2024/2/19
 */
public class OptionalCreateDemo {
    /**
     * 创建Option.empty()
     */
    @Test
    public void createsEmptyOptional() {
        Optional<String> empty = Optional.empty();
        Assert.assertFalse(empty.isPresent());
    }

    /**
     * Optional.of 创建非空对象
     */
    @Test
    public void createsNonNullable() {
        String name = "jingyes";
        Optional<String> opt = Optional.of(name);
        Assert.assertTrue(opt.isPresent());
    }

    /**
     * Optional.of 传null会抛异常
     */
    @Test(expected = NullPointerException.class)
    public void optional_of_null() {
        Optional.of(null);
    }

    /**
     * Optional.ofNullable 创建可空对象
     */
    @Test
    public void createsNullable() {
        String name = "jingyes";
        Optional<String> opt = Optional.ofNullable(name);
        Assert.assertTrue(opt.isPresent());

        opt = Optional.ofNullable(null);
        Assert.assertFalse(opt.isPresent());
    }
}
