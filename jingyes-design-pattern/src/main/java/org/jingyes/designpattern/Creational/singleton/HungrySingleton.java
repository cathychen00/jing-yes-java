package org.jingyes.designpattern.Creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 饿汉式单例模式
 *
 * @author jingyes
 * @date 2023/11/29
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //比较是否指向同一实例
        HungrySingleton instance1 = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        System.out.println(instance1==instance2);//true

        //反射攻击测试
        attach(HungrySingleton.class); //false
    }

    private static void attach(Class<?> classType) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //通过反射获取构造函数
        Constructor<?> constructor = classType.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        //构造两个实例
        HungrySingleton instance = (HungrySingleton) constructor.newInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        System.out.println(instance==instance2);
    }
}
