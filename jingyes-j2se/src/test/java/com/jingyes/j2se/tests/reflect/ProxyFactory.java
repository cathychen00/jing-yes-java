package com.jingyes.j2se.tests.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author chenjing
 * @date 2020/12/8
 */
public class ProxyFactory {
    public static Object getProxy(Object target) {
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            System.out.println("before method");
            method.invoke(target, args);
            System.out.println("after method");
            return null;
        };

        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                invocationHandler
        );
    }
}
