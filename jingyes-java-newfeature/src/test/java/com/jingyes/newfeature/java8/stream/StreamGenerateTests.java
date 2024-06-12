package com.jingyes.newfeature.java8.stream;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author jingyes
 * @date 2021/7/13
 */
public class StreamGenerateTests {
    @Test
    public void iterate() {
        Stream.iterate(0, n -> n + 2)
                .limit(5)
                .forEach(System.out::println);

    }

    @Test
    public void generate() {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
