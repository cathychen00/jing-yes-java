package org.jingyes.designpattern.Creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 静态内部类实现单例模式
 * 外面的类被加载的时候，内部类是不会被自动加载的。JVM保证线程安全，加载一个class的时候只加载一次
 *
 * @author jingyes
 * @date 2023/11/30
 */
public class StatisticSingleton {
    private StatisticSingleton() {
    }

    public static StatisticSingleton getInstance() {
        return Holder.INSTANCE;
    }

    //内部静态内实现的懒加载
    private static class Holder {
        private static final StatisticSingleton INSTANCE = new StatisticSingleton();
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        StatisticSingleton instance = StatisticSingleton.getInstance();
        StatisticSingleton instance2 = StatisticSingleton.getInstance();
        System.out.println(instance2 == instance);
        //反射攻击测试
        attach(StatisticSingleton.class); //false
    }

    private static void attach(Class<?> classType) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //通过反射获取构造函数
        Constructor<?> constructor = classType.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        //构造两个实例
        StatisticSingleton instance = (StatisticSingleton) constructor.newInstance();
        StatisticSingleton instance2 = StatisticSingleton.getInstance();
        System.out.println(instance == instance2);
    }
}
