package com.jingyes.newfeature.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author chenjing
 * @date 2021/5/6
 */
public class StreamIterator {
    /**
     * stream只能遍历一次
     */
    @Test
    public void once() {
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
        //这里会抛异常
        stream.forEach(System.out::println);
    }
}
