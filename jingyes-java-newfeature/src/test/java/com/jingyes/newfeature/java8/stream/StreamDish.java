package com.jingyes.newfeature.java8.stream;

import com.jingyes.newfeature.entity.Dish;
import org.junit.Test;

import java.util.stream.Collectors;

/**
 * @author chenjing
 * @date 2021/5/6
 */
public class StreamDish {
    //筛选能量低的食物，并打印名称
    @Test
    public void getLowCaloricDishesNames() {
        Dish.menu.stream()
                .filter(d -> d.getCalories() < 400)
                .limit(3)
                .map(Dish::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
