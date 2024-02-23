package com.jingyes.j2se.tests.generic;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 陈敬
 * @date 2020/8/4
 * Java的泛型是采用擦拭法实现的,所谓擦拭法是指，虚拟机对泛型其实一无所知，所有的工作都是编译器做的。
 * 局限一：<T>不能是基本类型，例如int，因为实际类型是Object，Object类型无法持有基本类型
 * 局限二：无法取得带泛型的Class，例如：Pair<String>.class；
 * 局限三：无法判断带泛型的类型，例如：x instanceof Pair<String>；
 * 局限四：不能实例化T类型，例如：new T()。
 */
public class GenericTests {
    /**
     * 测试泛型继承
     * 可以把ArrayList<Integer>向上转型为List<Integer>（T不能变！），
     * 但不能把ArrayList<Integer>向上转型为ArrayList<Number>（T不能变成父类）
     */
    @Test
    public void extend() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        System.out.println(list);
        //编译错误
//        ArrayList<Number> list2=new ArrayList<Integer>();
    }

    /**
     * 擦除例子1：getClass相同
     */
    @Test
    public void test1() {
        Pair<Integer> p1 = new Pair<>(1);
        Pair<String> p2 = new Pair<>("aa");
        System.out.println(p1.getClass());
        System.out.println(p2.getClass());
//        无论T的类型是什么，getClass()返回同一个Class实例，因为编译后它们全部都是Pair<Object>
        Assert.assertTrue(p1.getClass() == p2.getClass());
    }

    /**
     * 擦除例子2：通过反射添加不同类型的元素
     */
    @Test
    public void reflect() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.getClass().getMethod("add", Object.class).invoke(list, "test");
        System.out.println(list);
    }

    /**
     * instanceOf无法判断泛型具体类型
     */
    @Test
    public void instanceof_test() {
        Pair<Integer> p1 = new Pair<>(1);
        System.out.println(p1 instanceof Pair);
//        System.out.println(p1 instanceof Pair<Integer>);//编译错误
    }

    @Test
    public void testExtends() {
        Pair<Integer> p1 = new Pair<>(1);
        Assert.assertEquals(1,get(p1));
    }

    int get(Pair<? extends Number> pair) {
        return pair.getFirst().intValue();
    }

    @Test
    public void testSuper() {
        Pair<Number> p1 = new Pair<>(1);
        set(p1,100);
        System.out.println(get(p1));
    }
   void set(Pair<? super Integer> pair,Integer val){
        pair.setFirst(val);
   }
}
