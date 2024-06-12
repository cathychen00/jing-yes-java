package org.jingyes.j2se.exception;

/**
 * @author jingyes
 * @date 2018/6/23
 */
public class exceptionRetry {
    static int count = 1;

    public static void f() throws MyException {
        throw new MyException();
    }

    public static void main(String[] args) {
        while (count <= 5) {
            try {
                f();
            } catch (MyException e) {
                e.printStackTrace();
            } finally {
                System.out.println("次数" + count);

                count++;
                if (count > 1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}

class MyException extends Exception {
}
