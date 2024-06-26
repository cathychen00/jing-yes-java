package com.jingyes.j2se.tests.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jingyes
 * @date 2020/12/8
 */
public class ArraysAsListTests {
    @Test
    public void f1() {
        String[] myArray = {"Apple", "Banana", "Orange"};
        List<String> myList = Arrays.asList(myArray);
        System.out.println(myList);

        //上面两个语句等价于下面一条语句
        List<String> myList2 = Arrays.asList("Apple", "Banana", "Orange");
        System.out.println(myList2);
    }

    /**
     * 不能使用add,remove,clear等方法。
     * Arrays.asList() 方法返回的并不是 java.util.ArrayList ，而是 java.util.Arrays 的一个内部类,这个内部类并没有实现集合的修改方法或者说并没有重写这些方法。
     */
    @Test
    public void f2() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.add(4);//报错
    }

    /**
     * 传入基本类型和包装类型数组
     */
    @Test
    public void f3() {
        System.out.println("测试基本类型");
        int[] myArray = {1, 2, 3};
        List myList = Arrays.asList(myArray);
        System.out.println("size=" + myList.size());//size=1
        System.out.println("get(0)=" + myList.get(0));//数组地址值
//        System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
        int[] array = (int[]) myList.get(0);
        System.out.println(array[0]);//1
        System.out.println(array[1]);//2

        System.out.println("测试包装类型");
        Integer[] arr2 = {1, 2, 3};
        List list2 = Arrays.asList(arr2);
        System.out.println("size=" + list2.size());//size=3
        System.out.println("get(0)=" + list2.get(0));//1
        System.out.println("get(1)=" + list2.get(1));//2
    }
}
