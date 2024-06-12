package com.jingyes.newfeature.java8.lambda;

import com.jingyes.newfeature.entity.Apple;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author jingyes
 * @date 2021/4/23
 */
public class Sorting {
    @Test
    public void sort1() {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red")
        );

        inventory.sort(Comparator.comparing(Apple::weight));
        System.out.println(inventory);
    }

    @Test
    public void reverse() {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red")
        );

        inventory.sort(Comparator.comparing(Apple::weight)
                .reversed());
        System.out.println(inventory);
    }

    @Test
    public void multiOrder() {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green")
                , new Apple(120, "yellow")
                , new Apple(155, "green")
                , new Apple(120, "red")
        );

        inventory.sort(Comparator.comparing(Apple::weight)
                .thenComparing(Apple::color)
                .reversed());
        System.out.println(inventory);
    }
}
