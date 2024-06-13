package org.jingyes.j2se.exception;

/**
 * 如果在finally子句中使用return，会屏蔽异常
 *
 * @author jingyes
 * @date 2018/6/23
 */
public class ExceptionSilencer {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            //return会屏蔽掉异常
            return;
        }
    }
}
