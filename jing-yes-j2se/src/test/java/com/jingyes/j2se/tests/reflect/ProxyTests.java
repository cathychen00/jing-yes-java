package com.jingyes.j2se.tests.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

interface Hello {
    void morning(String name);

    void after(String name);
}

/**
 * @author 陈敬
 * @date 2020/8/3
 */
public class ProxyTests {
    @Test
    public void jdkProxy() {
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            if (method.getName().equals("morning")) {
                System.out.println("Good morning," + args[0]);
            }
            return null;
        };

        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[]{Hello.class},
                invocationHandler
        );
        hello.morning("baby");
        hello.after("haha");
    }

    @Test
    public void proxyFactoryTest() {
        Hello hello = (Hello) ProxyFactory.getProxy(new HelloImpl());
        hello.morning("tom");
    }
}
