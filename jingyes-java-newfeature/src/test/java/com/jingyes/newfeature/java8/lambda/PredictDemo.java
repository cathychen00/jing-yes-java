package com.jingyes.newfeature.java8.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 测试java8内置的函数式接口 Predict
 *
 * @author jingyes
 * @date 2024/2/19
 */
public class PredictDemo {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 5, 6, 7, 8, 10);

        Predicate<Integer> p1 = x -> x % 2 == 0;
        Predicate<Integer> p2 = x -> x % 3 == 0;

        print(list, p1, System.out::println);
        print(list, p2, System.out::println);

        //and连接
        print(list, p1.and(p2), System.out::println);
    }

    private static void print(List<Integer> list, Predicate<Integer> predicate, Consumer<Integer> consumer) {
        list.forEach(x -> {
            if (predicate.test(x)) {
                consumer.accept(x);
            }
        });
        System.out.println("*************");
    }
}
