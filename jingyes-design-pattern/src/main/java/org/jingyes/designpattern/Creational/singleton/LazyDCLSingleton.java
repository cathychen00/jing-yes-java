package org.jingyes.designpattern.Creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

/**
 * 懒汉式单例，即用到的时候才实例化
 * 注意：需要处理多线程并发问题
 * 使用双重锁检查，注意需要添加volatile关键字，防止指令重排
 *
 * @author 陈敬
 * @date 2023/11/29
 */
public class LazyDCLSingleton {
    //注意，这里要加上volatile，防止指令重排
    private volatile static LazyDCLSingleton instance = null;

    private LazyDCLSingleton() {

    }

    public static LazyDCLSingleton getInstance() {
        //第一次检查
        if (instance == null) {
            synchronized (LazyDCLSingleton.class) {
                //第二次检查
                if (instance == null) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new LazyDCLSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(LazyDCLSingleton.getInstance().hashCode());
            }).start();
        }
        //反射攻击测试
        attach(LazyDCLSingleton.class); //false
    }

    private static void attach(Class<?> classType) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //通过反射获取构造函数
        Constructor<?> constructor = classType.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        //构造两个实例
        LazyDCLSingleton instance = (LazyDCLSingleton) constructor.newInstance();
        LazyDCLSingleton instance2 = LazyDCLSingleton.getInstance();
        System.out.println(instance == instance2);
    }
}
