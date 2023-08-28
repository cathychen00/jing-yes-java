package org.jingyes.j2se.code02.constructdemo;

/**
 * 构造函数示例
 * @author 陈敬
 * @date 18/1/3
 */
public class Person {
    private String name;
    private Integer age;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Integer age) {
        this(name);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Person p = new Person("a", 11);
        System.out.println(p);
    }
}
