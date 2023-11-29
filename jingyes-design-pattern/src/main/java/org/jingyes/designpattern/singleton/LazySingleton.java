package org.jingyes.designpattern.singleton;

/**
 * 懒汉式单例
 * 注意：需要处理多线程并发问题，synchronized关键字
 *
 * @author 陈敬
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

    public static void main(String[] args) {
        LazySingleton instance = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        System.out.println(instance2 == instance);
    }
}
