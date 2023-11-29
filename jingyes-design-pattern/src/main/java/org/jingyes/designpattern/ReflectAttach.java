package org.jingyes.designpattern;

import org.jingyes.designpattern.singleton.HungrySingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 陈敬
 * @date 2023/11/29
 */
public class ReflectAttach {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //饿汉式单例，false
        System.out.println(attach(HungrySingleton.class));
    }

    private static boolean attach(Class<?> classType) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //通过反射获取构造函数
        Constructor<?> constructor = classType.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        //构造两个实例
        HungrySingleton instance = (HungrySingleton) constructor.newInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        //比较是否为同一实例
        return instance == instance2;
    }
}
