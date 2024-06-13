package org.jingyes.j2se.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 动态代理方式二：cglib实现动态代理
 * * 优点：比JDK Proxy更简单，不需要接口
 * * 缺陷：cglib其实是生成了Tank子类，所以如果Tank是final类，cglib不能实现动态代理。
 * * cglib底层实现用的也是asm
 *
 * 注意：java17要引入依赖cglib
 *
 * @author chenjing
 * @date 2020/12/1
 */
public class Main2 {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        Tank tank1 = (Tank) enhancer.create();
        tank1.move();
    }
}

class TimeMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("super classname is:" + o.getClass().getSuperclass().getName());
        Long start = System.currentTimeMillis();
        System.out.println("start " + method.getName());

        Object result = methodProxy.invokeSuper(o, objects);

        System.out.println("end " + method.getName());
        Long end = System.currentTimeMillis();
        System.out.println("执行时间 " + (end - start));

        return result;
    }
}

