package com.jingyes.newfeature.java17;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Steam.toList()简化语法
 *
 * @author 陈敬
 * @date 2024/2/19
 */
public class StreamToListDemo {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        //旧语法
        List<Integer> list = integerStream.collect(Collectors.toList());
        //新语法
        List<Integer> list2 = integerStream.toList();
    }
}
