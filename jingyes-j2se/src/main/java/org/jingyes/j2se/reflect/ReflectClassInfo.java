package org.jingyes.j2se.reflect;

/**
 * 通过反射获取Class Info
 * @author jingyes
 * @date 2021/3/31
 */
public class ReflectClassInfo {
    public static void main(String[] args) {
        Class class1 = String.class;
        printClassInfo(class1);

        Class cls2 = "hello".getClass();
        printClassInfo(cls2);

        Class cls3 = String[].class;
        printClassInfo(cls3);

        //true,指向同一个实例
        System.out.println("class1 == cls2? " + (class1 == cls2));
    }

    private static void printClassInfo(Class c) {
        System.out.println("*******Print*********");
        System.out.println("getName()=" + c.getName());
        System.out.println("getSimpleName()=" + c.getSimpleName());
        System.out.println("isInterface()=" + c.isInterface());
        System.out.println("isEnum()=" + c.isEnum());
        System.out.println("isArray()=" + c.isArray());
        System.out.println("isPrimitive=" + c.isPrimitive());
    }
}
