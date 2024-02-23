package com.jingyes.j2se.tests.generic;

/**
 * @author 陈敬
 * @date 2024/2/23
 */
public class Pair<T> {
    private T first;

    public Pair(T first) {
        this.first = first;
    }

//    public Pair(){
////    不能实例化T类型，编译错误
//        this.first=new T();
//    }

    public Pair(Class<T> cls) throws IllegalAccessException, InstantiationException {
        this.first = cls.newInstance();
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    /**
     * 静态方法不能引用泛型类型<T>，必须定义其他类型（例如<E>）来实现静态泛型方法
     * 这样才能清楚地将静态方法的泛型类型和实例类型的泛型类型区分开
     */
    public static <E> Pair<E> create(E first) {
        return new Pair<E>(first);
    }
}
