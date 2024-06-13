package org.jingyes.j2se.stastic;

/**
 * 静态代码块
 * 如果静态代码块有多个，JVM将按照它们在类中出现的先后顺序依次执行它们，每个代码块只会被执行一次。
 * 静态代码块对于定义在它之后的静态变量，可以赋值，但是不能访问。
 *
 * @author chenjing
 * @date 2020/12/8
 */
public class StaticDemo {
    static int i;

    static {
        i = 5;

        System.out.println(i);
    }
//    静态代码块对于定义在它之后的静态变量，可以赋值，但是不能访问。
//    static int i;
}
