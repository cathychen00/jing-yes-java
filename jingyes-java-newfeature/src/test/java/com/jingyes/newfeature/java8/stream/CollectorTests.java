package com.jingyes.newfeature.java8.stream;

import com.jingyes.newfeature.entity.Dish;
import org.junit.Test;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * @author chenjing
 * @date 2021/7/14
 */
public class CollectorTests {
    @Test
    public void count() {
        //Collectors.counting()
        System.out.println(Dish.menu.stream().collect(Collectors.counting()));
        //count()
        System.out.println(Dish.menu.stream().count());
    }

    @Test
    public void max() {
        //max求最大值
        Comparator<Dish> maxCalories = Comparator.comparing(Dish::getCalories);
        Optional<Dish> optional = Dish.menu.stream().max(maxCalories);
        System.out.println(optional.get());
        //reducing求最大值
        Optional<Dish> max = Dish.menu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println(max.get());
    }

    @Test
    public void summary() {
        //Collectors.summingInt求和
        Integer total = Dish.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(total);
        //Collectors.reducing规约求和
        Integer total2 = Dish.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (x, y) -> x + y));
        System.out.println(total);

        Integer total3 = Dish.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(total3);

        OptionalInt total4 = Dish.menu.stream().mapToInt(Dish::getCalories).reduce(Integer::sum);
        System.out.println(total4.getAsInt());
    }

    /**
     * 字符串连接
     */
    @Test
    public void join() {
        String shortMenu = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.println(shortMenu);
    }
}
