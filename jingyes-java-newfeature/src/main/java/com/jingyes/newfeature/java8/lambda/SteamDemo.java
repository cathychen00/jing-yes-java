package com.jingyes.newfeature.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream 遍历
 *
 * @author 陈敬
 * @date 2024/2/19
 */
public class SteamDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");

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
