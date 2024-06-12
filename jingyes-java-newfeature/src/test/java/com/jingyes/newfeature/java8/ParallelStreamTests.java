package com.jingyes.newfeature.java8;

import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

/**
 * parallel stream
 * Fork/Join方式，适用于执行速度慢过线程切换消耗的情况
 *
 * @author jingyes
 * @date 2021/7/29
 */
public class ParallelStreamTests {
    @Rule
    public Stopwatch stopwatch = new Stopwatch() {
        @Override
        protected void succeeded(long nanos, Description description) {
//            logInfo(description, "succeeded", nanos);
        }

        @Override
        protected void skipped(long nanos, AssumptionViolatedException e, Description description) {
            logInfo(description, "skipped", nanos);
        }

        @Override
        protected void finished(long nanos, Description description) {
            logInfo(description, "finished", nanos);
        }
    };

    private static void logInfo(Description description, String status, long nanos) {
        String testName = description.getMethodName();
        System.out.println(String.format("Test %s %s, spent %d microseconds",
                testName, status, TimeUnit.NANOSECONDS.toMicros(nanos)));
    }

    @Test
    public void sequentSum() {
        Long n = 1000L;
        Long sum = LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
        System.out.println(sum);
    }

    /**
     * 并行流（ParallelStream）怎么会比顺序流（Stream）还慢？
     * 并行流（ParallelStream）的背后其实是 Java7 开始支持的 Fork/Join，即把一个大任务拆分成 N 个小任务，然后最终合并各个子任务的结果，
     * 但是对于子任务线程的拆分、创建、结果合并等操作都需要不少的开销，特别是线程的创建。
     * 所以这种不耗时的简单运算操作事实上是不适用于并行流（ParallelStream）的，它所带来的线程创建的损耗可能还会比顺序流（Stream）还要更慢。
     */
    @Test
    public void parallelSum() {
        Long n = 1000L;
        Long sum = LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
        System.out.println(sum);
    }

    @Test
    public void sequentSum2() {
        Long n = 1000L;
        LongStream.rangeClosed(1, n)
                .forEach(x -> {
                    try {
                        Thread.sleep(2L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    /**
     * 耗时运算，并行流明显处理快
     */
    @Test
    public void parallelSum2() {
        Long n = 1000L;
        LongStream.rangeClosed(1, n)
                .parallel()
                .forEach(x -> {
                    try {
                        Thread.sleep(2L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
