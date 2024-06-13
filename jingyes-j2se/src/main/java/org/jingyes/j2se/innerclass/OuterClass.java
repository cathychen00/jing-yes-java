package org.jingyes.j2se.innerclass;

/**
 * 内部类示例
 *
 * @author jingyes
 * @date 2018/6/16
 */
public class OuterClass {
    private String a;

    public OuterClass(String a) {
        this.a = a;
    }

    public InnerClass GetInner() {
        return new InnerClass();
    }

    public class InnerClass {
        public InnerClass() {
        }

        //内部类可以访问外部类的私有变量
        public void show() {
            System.out.println("outerClass.a=" + a);
        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass("test hello");
        InnerClass innerClass = outerClass.GetInner();
        innerClass.show();
    }
}
