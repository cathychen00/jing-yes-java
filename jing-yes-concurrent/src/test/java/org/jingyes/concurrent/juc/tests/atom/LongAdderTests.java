package org.jingyes.concurrent.juc.tests.atom;

import org.junit.Test;

import java.util.concurrent.atomic.LongAdder;

/**
 * LongAdder原子性操作类，该类通过内部cells数组分担了高并发下多线程同时对一个原子变量进行更新时的竞争量，
 * 让多个线程可以同时对cells数组里面的元素进行并行的更新操作。
 * 另外，数组元素Cell使用@sun.misc.Contended注解进行修饰，这避免了cells数组内多个原子变量被放入同一个缓存行，
 * 也就是避免了伪共享，这对性能也是一个提升。
 */
public class LongAdderTests {

    @Test
    public void longAdder() {
        LongAdder longAdder = new LongAdder();
        for (int i = 0; i < 10; i++) {
            longAdder.increment();
            System.out.println(longAdder.intValue());
        }
    }

    @Test
    public void longAdder_2() {
        LongAdder longAdder = new LongAdder();
        for (int i = 0; i < 10; i++) {
            longAdder.add(2L);
            System.out.println(longAdder.intValue());
        }
    }
}
