package com.jingyesjava.jvmdemo;

/**
 * 类初始化加载过程的例子
 *
 * @author jingyes
 * @date 2021/1/7
 */
class Grandpa {
    static {
        System.out.println("爷爷在静态代码块");
    }
}

class Father extends Grandpa {
    public static int factor = 25;

    static {
        System.out.println("爸爸在静态代码块");
    }

    public Father() {
        System.out.println("我是爸爸~");
    }
}

class Son extends Father {
    static {
        System.out.println("儿子在静态代码块");
    }

    public Son() {
        System.out.println("我是儿子~");
    }
}

public class InitializationDemo1 {
    public static void main(String[] args) {
        System.out.println("爸爸的岁数:" + Son.factor);    //入口
    }
}