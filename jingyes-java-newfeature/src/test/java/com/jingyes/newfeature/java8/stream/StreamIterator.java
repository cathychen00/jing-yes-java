package com.jingyes.newfeature.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author jingyes
 * @date 2021/5/6
 */
public class StreamIterator {
    /**
     * stream只能遍历一次
     */
    @Test(expected = Exception.class)
    public void once() {
        List<String> names = Arrays.asList("jing","yes");
        //迭代器可以遍历多次
        names.forEach(System.out::println);
        names.forEach(System.out::println);

        Stream<String> stream = names.stream();
        //Steam流只能遍历一次
        stream.forEach(System.out::println);
        //异常 stream has already been operated upon or closed
        stream.forEach(System.out::println);
    }
}
