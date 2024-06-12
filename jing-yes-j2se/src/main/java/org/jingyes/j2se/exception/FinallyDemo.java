package org.jingyes.j2se.exception;

/**
 * finally几种特殊场景
 *
 * @author jingyes
 * @date 2022/2/16
 */
public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println(finally1());
        System.out.println(finally2());
        System.out.println(finally3());
        System.out.println(finally4());
    }

    //finally重新赋值，不会影响返回值
    private static Integer finally1() {
        Integer ret = 1;
        try {
            return ret;
        } finally {
            //不会影响返回值
            System.out.println("finally1 执行finally");
            ret = 2;
        }
    }

    //finally return会覆盖try中的返回值
    private static Integer finally2() {
        try {
            return 1;
        } finally {
            System.out.println("finally2 执行finally");
            return 2;
        }
    }

    //直接在finally中return，会掩盖try中的异常
    private static Integer finally3() {
        try {
            Integer num = 5 / 0;
            return 1;
        } finally {
            System.out.println("finally3 执行finally");
            return 3;
        }
    }

    //try中return语句执行之后，仍然会执行finally
    private static Integer finally4() {
        try {
            return 4;
        } finally {
            System.out.println("finally4 clean up");
        }
    }
}
