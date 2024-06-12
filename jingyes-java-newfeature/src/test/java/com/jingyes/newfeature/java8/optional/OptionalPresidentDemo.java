package com.jingyes.newfeature.java8.optional;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * 判断Optional是否有值
 *
 * @author jingyes
 * @date 2024/2/19
 */
public class OptionalPresidentDemo {
    /**
     * check if there is a value in it
     */
    @Test
    public void isPresent() {
        Optional<String> opt = Optional.of("jingyes");
        Assert.assertTrue(opt.isPresent());

        opt = Optional.ofNullable(null);
        Assert.assertFalse(opt.isPresent());
    }

    /**
     * check if there is not a value in it
     */
    @Test
    public void isEmpty() {
        Optional<String> opt = Optional.of("jingyes");
        Assert.assertFalse(opt.isEmpty());

        opt = Optional.ofNullable(null);
        Assert.assertTrue(opt.isEmpty());
    }

    /**
     * The ifPresent() method enables us to run some code on the wrapped value if it’s found to be non-null
     */
    @Test
    public void ifPresent() {
        Optional<String> opt = Optional.of("jingyes");
        opt.ifPresent(name -> System.out.println("Hello " + name));
    }
}
