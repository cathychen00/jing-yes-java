package org.jingyes.concurrent.juc.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chenjing
 * @date 2020/12/22
 */
public class ReentrantLockReadAndWriteLockTests {
    @Test
    public void test() {
        ReentrantLockList list = new ReentrantLockList();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        System.out.println(list.get(1));
    }
}

class ReentrantLockList {
    private ArrayList<String> arrayList = new ArrayList<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void add(String e) {
        writeLock.lock();
        try {
            this.arrayList.add(e);
        } finally {
            writeLock.unlock();
        }
    }

    public void remove(String e) {
        writeLock.lock();
        try {
            this.arrayList.remove(e);
        } finally {
            writeLock.unlock();
        }
    }

    public String get(int index) {
        readLock.lock();
        try {
            return this.arrayList.get(index);
        } finally {
            readLock.unlock();
        }
    }
}
