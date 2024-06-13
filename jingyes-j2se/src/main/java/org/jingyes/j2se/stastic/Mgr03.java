package org.jingyes.j2se.stastic;

/**
 * 静态内部类实现单例模式
 * 外面的类被加载的时候，内部类是不会被自动加载的。
 * JVM保证线程安全，加载一个class的时候只加载一次
 *
 * @author jingyes
 * @date 2020/9/10
 */
public class Mgr03 {
    private Mgr03() {
    }

    public static Mgr03 getInstance() {
        return Mgr03Holder.INSTANCE;
    }

    private static class Mgr03Holder {
        private final static Mgr03 INSTANCE = new Mgr03();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //lambda表达式，如果接口只有一个方法，可以使用该写法，这里实现的是Runnable接口run方法
            new Thread(() -> System.out.println(Mgr03.getInstance().hashCode())).start();
        }
    }
}
