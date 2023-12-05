package org.jingyes.designpattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 枚举实现单例模式
 *
 * @author 陈敬
 * @date 2023/11/30
 */
public enum EnumSingleton {
    INSTANCE;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        EnumSingleton instance = EnumSingleton.INSTANCE;
        EnumSingleton instance2 = EnumSingleton.INSTANCE;
        //是否指向同一实例
        System.out.println(instance==instance2);
        //设置属性值
        instance.setValue(100);
        System.out.println(instance2.value);
        //反射攻击测试，失败，直接异常
        attach(EnumSingleton.class);
    }

    private static void attach(Class<?> classType) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //通过反射获取构造函数
        Constructor<?> constructor = classType.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        //构造两个实例
        EnumSingleton instance = (EnumSingleton) constructor.newInstance();
        EnumSingleton instance2 = EnumSingleton.INSTANCE;
        System.out.println(instance == instance2);
    }
}
