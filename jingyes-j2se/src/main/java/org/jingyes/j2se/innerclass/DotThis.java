package org.jingyes.j2se.innerclass;

/**
 * .this可以生成对外部类的引用。
 *
 * @author jingyes
 * @date 2020/12/8
 */
public class DotThis {
    public class Inner {
        public DotThis outer() {
            return DotThis.this;
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public void print(String s) {
        System.out.println("外部类打印 print():" + s);
    }

    public static void main(String[] args) {
        DotThis dotThis = new DotThis();
        DotThis.Inner inner = dotThis.inner();
        inner.outer().print("Hello");
    }
}
