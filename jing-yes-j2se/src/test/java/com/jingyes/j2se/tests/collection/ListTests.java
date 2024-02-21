package com.jingyes.j2se.tests.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author 陈敬
 * @date 2020/8/4
 */
public class ListTests {
    @Test
    public void equals() {
        Person p1 = new Person(18, "Tom");
        Person p2 = new Person(20, "Wang");
        List<Person> list = Arrays.asList(p1, p2);
        //如果想返回true需要覆写Person.equals方法
        System.out.println(list.contains(new Person(18, "Tom")));
    }

    @Test
    public void remove_iterator() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("2")) {
                iterator.remove();
            }
        }
        list.stream().forEach(System.out::println);
    }

    /**
     * Java8开始，可以使用Collection#removeIf()方法删除满足特定条件的元素
     */
    @Test
    public void removeIf() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.removeIf(x -> x.equals("1"));
        System.out.println(list);
    }

    @Test
    public void remove1() {
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");

        for (String item : list) {
            if ("1".equals(item)) {
                list.remove(item);
            }
        }
        list.stream().forEach(System.out::println);
    }
}

record Person(int age, String name){}
