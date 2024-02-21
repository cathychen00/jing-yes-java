package com.jingyes.j2se.tests.collection;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author chenjing
 * @date 2021/3/30
 */
public class SuffleDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(list);

        Random rnd = new Random(2);//给定随机种子
        Collections.shuffle(list, rnd);
        System.out.println("add rnd:" + list.toString());
    }
}
