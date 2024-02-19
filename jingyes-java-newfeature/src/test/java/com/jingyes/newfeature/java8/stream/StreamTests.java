package com.jingyes.newfeature.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenjing
 * @date 2021/1/27
 * Stream 操作分为中间操作或者最终操作两种，最终操作返回一特定类型的计算结果，而中间操作返回Stream本身，这样你就可以将多个操作依次串起来。
 * Stream 的创建需要指定一个数据源，比如 java.util.Collection 的子类，List 或者 Set， Map 不支持。
 */
public class StreamTests {
    List<String> stringList = new ArrayList<>();

    @Before
    public void init() {
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");
    }

    /*
    filter 通过一个predicate接口来过滤并只保留符合条件的元素，该操作属于中间操作
    forEach 是一个最终操作，所以我们不能在forEach之后来执行其他Stream操作。
     */
    @Test
    public void filter() {
        stringList.stream()
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);
    }

    /**
     * sort 排序是一个 中间操作，返回的是排序好后的 Stream。
     * 如果你不指定一个自定义的 Comparator 则会使用默认排序。
     */
    @Test
    public void sort() {
        stringList.stream()
                .filter(x -> x.startsWith("a"))
                .sorted()
                .forEach(System.out::println);

        //排序只创建了一个排列好后的Stream，而不会影响原有的数据源，排序之后原数据stringCollection是不会被修改的
        System.out.println(stringList);
    }

    /**
     * 中间操作 map 会将元素根据指定的 Function 接口来依次将元素转成另外的对象。
     */
    @Test
    public void map() {
        stringList.stream()
                .map(String::toUpperCase)
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }

    //返回平方数
    @Test
    public void map2() {
        Integer[] nums = {1, 2, 3, 4, 5};
        Arrays.stream(nums)
                .map(x -> x * x)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void map3() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 5);
        List<Integer[]> result = list1.stream()
                .flatMap(x ->
                        list2.stream()
                                .map(y -> new Integer[]{x, y})
                )
                .collect(Collectors.toList());
    }

    @Test
    public void flat_map() {
        stringList.stream()
                .map(x -> x.split(""))
                .flatMap(Arrays::stream)
//                .distinct()
                .forEach(System.out::println);
    }

    /**
     * Stream提供了多种匹配操作，允许检测指定的Predicate是否匹配整个Stream。
     * 所有的匹配操作都是 最终操作 ，并返回一个 boolean 类型的值。
     */
    @Test
    public void match() {
        Boolean anyStartWithA = stringList.stream()
                .anyMatch(x -> x.startsWith("a"));
        System.out.println(anyStartWithA);

        Boolean allStartWithA = stringList.stream()
                .allMatch(x -> x.startsWith("a"));
        System.out.println(allStartWithA);

        Boolean noneStartWithA = stringList.stream()
                .noneMatch(x -> x.startsWith("a"));
        System.out.println(noneStartWithA);
    }

    /**
     * 计数是一个 最终操作，返回Stream中元素的个数，返回值类型是 long
     */
    @Test
    public void count() {
        long count = stringList
                .stream()
                .filter(x -> x.startsWith("b"))
                .count();
        System.out.println(count);
    }

    //    最终操作 ，允许通过指定的函数来讲stream中的多个元素规约为一个元素，
    @Test
    public void reduce() {
        //有起始值的 reduce() 都返回具体的对象
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(sumValue);

        //没起始值的reduce(),规约后的结果是通过Optional 接口表示的
        Optional<String> reduce = stringList
                .stream()
                .reduce((x, y) -> x + "," + y);
        reduce.ifPresent(System.out::println);

        //最小值
        Optional<Integer> minValue = Stream.of(1, 2, 3, 4).reduce(Integer::min);
        System.out.println(minValue.get());

        //最大值
        Optional<Integer> max = Stream.of(1, 2, 3, 4).reduce(Integer::max);
        System.out.println(max.get());
    }
}
