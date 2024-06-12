package org.jingyes.j2se.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理方式一：JDK反射实现动态代理
 * * 优点：Tank为final类也可以支持，因为asm可以修改字节码。
 * * 缺陷：JDK proxy必须面向接口，底层实现涉及到asm。
 *
 * @author chenjing
 * @date 2020/12/1
 */
public class Main {
    public static void main(String[] args) {
        //系统属性，保存代理生成的类
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //新版本java用这个属性
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        Tank t = new Tank();
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Long start = System.currentTimeMillis();
                method.invoke(t, args);
                Long end = System.currentTimeMillis();
                System.out.println("执行时间 " + (end - start));
                return this;
            }
        });

        m.move();
    }
}
