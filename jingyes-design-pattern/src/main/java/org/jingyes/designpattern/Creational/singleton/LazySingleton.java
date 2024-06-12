package org.jingyes.designpattern.Creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 懒汉式单例
 * 注意：需要处理多线程并发问题，synchronized关键字
 *
 * @author jingyes
 * @date 2023/11/29
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton() {

    }

    //synchronized解决线程安全问题，但是影响性能
    public synchronized static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //是否指向同一实例
        LazySingleton instance = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        System.out.println(instance2 == instance);

        //反射攻击测试
        attach(LazySingleton.class); //false
    }

    private static void attach(Class<?> classType) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //通过反射获取构造函数
        Constructor<?> constructor = classType.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        //构造两个实例
        LazySingleton instance = (LazySingleton) constructor.newInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        System.out.println(instance == instance2);
    }
}
