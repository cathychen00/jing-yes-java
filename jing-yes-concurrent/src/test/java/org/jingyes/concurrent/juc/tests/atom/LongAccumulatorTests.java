package org.jingyes.concurrent.juc.tests.atom;

import org.junit.Test;

import java.util.concurrent.atomic.LongAccumulator;

/**
 * LongAccumulator
 *
 * @author jingyes
 * @date 2024/5/9
 */
public class LongAccumulatorTests {

    /**
     * LongAccumulator可以自定义二目运算
     */
    @Test
    public void test_long_accumulator() {
        LongAccumulator num = new LongAccumulator((a, b) -> a * b, 1);
        for (int i = 0; i < 10; i++) {
            num.accumulate(2);
            System.out.println(num);
        }
    }
}
