package com.jingyes.newfeature.java8.lambda;


import com.jingyes.newfeature.entity.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author chenjing
 * @date 2021/4/22
 * @description 行为参数化加泛型，实现通用集合筛选
 */
public class FilterApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> greenApples = filter(inventory, FilterApples::isGreenApple);
        System.out.println(greenApples);
        List<Apple> heavyApples = filter(inventory, FilterApples::isHeavyApple);
        System.out.println(heavyApples);

        List<Apple> greenApples2 = filter(inventory, a -> "green".equals(a.color()));
        System.out.println(greenApples2);
        List<Apple> heavyApples2 = filter(inventory, a -> a.weight() > 150);
        System.out.println(heavyApples2);

        List<Integer> nums = filter(List.of(1, 2, 10, 20), n -> n < 10);
        System.out.println(nums);
    }

    /**
     * 筛选集合
     *
     * @param list      待筛选集合
     * @param predicate 过滤操作，行为参数化
     * @param <T>       泛型
     * @return 筛选结果
     */
    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.color());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.weight() > 150;
    }
}
