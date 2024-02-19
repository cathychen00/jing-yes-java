package com.jingyes.newfeature.java8.stream;

import com.cathyjava.corejava.tests.java8.entity.Dish;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chenjing
 * @date 2021/7/14
 */
public class GroupTests {
    //按照单个属性分组
    @Test
    public void groupByType() {
        Map<Dish.Type, List<Dish>> collect = Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(collect);
    }

    //按照热量范围分组
    @Test
    public void groupByLevel() {
        Map<CaloriesLevel, List<Dish>> map = Dish.menu.stream()
                .collect(Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloriesLevel.DIET;
                    } else if (dish.getCalories() >= 700) {
                        return CaloriesLevel.FAT;
                    } else {
                        return CaloriesLevel.NORMAL;
                    }
                }));
        System.out.println(map);
    }

    /**
     * 多级分组
     */
    @Test
    public void groupByTypeAndLevel() {
        Map<Dish.Type, Map<CaloriesLevel, List<Dish>>> collect = Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloriesLevel.DIET;
                    } else if (dish.getCalories() >= 700) {
                        return CaloriesLevel.FAT;
                    } else {
                        return CaloriesLevel.NORMAL;
                    }
                })
        ));
        System.out.println(collect);
    }

    public enum CaloriesLevel {DIET, NORMAL, FAT}
}
