package org.jingyes.concurrent.juc;

import org.openjdk.jol.info.ClassLayout;

/**
 * 用JOL查看内存情况
 */
public class JOLDemo {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println(ClassLayout.parseClass(Long.class).toPrintable());
    }
}
