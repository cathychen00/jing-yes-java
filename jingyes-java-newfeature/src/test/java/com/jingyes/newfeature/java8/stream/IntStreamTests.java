package com.jingyes.newfeature.java8.stream;

import com.jingyes.newfeature.entity.Dish;
import org.junit.Test;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @author chenjing
 * @date 2021/6/26
 */
public class IntStreamTests {
    //数值流
    @Test
    public void int_stream() {
        int sum = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(sum);
    }

    @Test
    public void optional_int() {
        OptionalInt max = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        System.out.println(max.getAsInt());
    }

    @Test
    public void range() {
        //range不包含右端点
        long count = IntStream.range(1, 100)
                .filter(x -> x % 2 == 0)
                .count();
        System.out.println(count);//49

        //rangeClose包含右端点
        long count2 = IntStream.rangeClosed(1, 100)
                .filter(x -> x % 2 == 0)
                .count();
        System.out.println(count2);//50
    }
}
