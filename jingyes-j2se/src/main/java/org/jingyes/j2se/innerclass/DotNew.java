package org.jingyes.j2se.innerclass;

/**
 * .new用来创建内部类的实体
 * 不能使用类似new DotNew.Inner()来创建内部类，而是先创建外部类对象，然后使用外部类对象创建内部类对象。
 *
 * @author jingyes
 * @date 2020/12/8
 */
public class DotNew {
    public class Inner {
        public void print(String s) {
            System.out.println("Inner.print():" + s);
        }
    }

    public static void main(String[] args) {
        DotNew dotNew = new DotNew();
        DotNew.Inner inner = dotNew.new Inner();
        inner.print("Hello");
    }
}
