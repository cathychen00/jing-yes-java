package org.jingyes.designpattern.singleton;

/**
 * 饿汉式单例模式
 *
 * @author 陈敬
 * @date 2023/11/29
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        HungrySingleton instance1 = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        System.out.println(instance1==instance2);
    }
}
