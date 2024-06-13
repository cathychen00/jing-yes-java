package org.jingyes.j2se.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射获取私有字段
 *
 * @author jingyes
 * @date 2021/3/31
 */
public class ReflectMethod {
    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        method();
        privateField();
    }

    private static void method() throws NoSuchFieldException {
        Class cls = Student.class;
        System.out.println(cls.getField("score"));
        System.out.println(cls.getDeclaredField("score"));
        //获取私有方法报错
//        System.out.println(cls.getField("grade"));
        System.out.println(cls.getDeclaredField("grade"));
    }


    private static void privateField() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class cls = Class.forName("com.cathyjava.j2se.reflect.Student");
        Student student = (Student) cls.getDeclaredConstructor().newInstance();
        Field field = cls.getDeclaredField("grade");
        field.setAccessible(true);
        field.set(student, 2);
    }
}

class Student extends Person {
    public int score;
    private int grade;
}

class Person {
    public String name;
}
