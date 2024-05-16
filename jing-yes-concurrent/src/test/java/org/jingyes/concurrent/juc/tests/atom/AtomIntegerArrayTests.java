package org.jingyes.concurrent.juc.tests.atom;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * AtomicIntegerArray示例，原子更新数组中某个元素
 *
 * @author 陈敬
 * @date 2024/5/9
 */
public class AtomIntegerArrayTests {
    @Test
    public void test() {
        final int[] array = {1, 3, 5, 7, 9};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(array);
        System.out.println(atomicIntegerArray);

        System.out.println(atomicIntegerArray.getAndIncrement(0));
        System.out.println(atomicIntegerArray);

        System.out.println(atomicIntegerArray.getAndAdd(1, 5));
        System.out.println(atomicIntegerArray);

        System.out.println(atomicIntegerArray.getAndSet(2, 10));
        System.out.println(atomicIntegerArray);
    }
}
