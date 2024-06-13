package org.jingyes.concurrent.juc.tests.atom;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

/**
 * AtomicLong
 * CAS非阻塞算法,UnSafe实现，
 * 多线程竞争同一个原子变量，高并发下性能瓶颈
 *
 * @author jingyes
 * @date 2020/12/17
 */
public class AtomLongTests {

    @Test
    public void atomLong() {
        AtomicLong atomicLong = new AtomicLong();
        System.out.println(atomicLong.addAndGet(1));
    }
}
