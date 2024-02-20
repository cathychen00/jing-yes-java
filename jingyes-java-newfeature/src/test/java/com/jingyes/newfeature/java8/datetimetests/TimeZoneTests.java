package com.jingyes.newfeature.java8.datetimetests;

import org.junit.Test;

import java.util.TimeZone;

/**
 * 通过指定的时区处理日期时间
 *
 * @author chenjing
 * @date 2022/2/17
 */
public class TimeZoneTests {
    @Test
    public void test() {
        //获取当前时区
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(timeZone.getID());
        System.out.println(timeZone.getDisplayName());
        //java系统属性
        System.out.println(System.getProperty("user.timezone"));
    }

    /**
     * 静态方法，获取时区实例
     */
    @Test
    public void test2() {
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
        System.out.println(timeZone);
        TimeZone timeZone1 = TimeZone.getTimeZone("GMT+08:00");
        System.out.println(timeZone1);
    }
}
