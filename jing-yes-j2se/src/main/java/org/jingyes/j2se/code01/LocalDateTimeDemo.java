package org.jingyes.j2se.code01;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author 陈敬
 * @date 18/1/2
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        testDate();
        testLocalDate();
        testLocalTime();
        parseDate();
        test();
    }

    private static void testDate() {
        //Date很多方法已经过时，不推荐使用
        Date date = new Date();
        System.out.println(date);//Tue Jan 02 13:09:40 CST 2018
        //getYear，不是返回当前年份
        System.out.println(date.getYear());//118
    }


    private static void testLocalDate() {
        //当前日期
        LocalDate today = LocalDate.now();
        System.out.println(today);//2017-12-26
        //构造指定日期
        LocalDate newYear = LocalDate.of(2018, 1, 1);
        System.out.println(newYear);//2018-01-01
        //15天后
        LocalDate date15 = today.plusDays(15);
        System.out.println(date15);//2018-01-10
        //获取年、月、日
        System.out.println(date15.getYear());//2018
        System.out.println(date15.getMonth());//JANUARY
        System.out.println(date15.getMonthValue());//1
        System.out.println(date15.getDayOfMonth());//10
        System.out.println(date15.getDayOfWeek());//WEDNESDAY
        System.out.println(date15.getDayOfYear());//10
    }

    private static void testLocalTime() {
        //当前时间
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);//12:23:09.054
        //当前日期时间
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);//2017-12-26T12:23:09.054
    }


    private static void parseDate() {
        //解析日期字符串
        LocalDate date1 = LocalDate.parse("2018-12-31");
        System.out.println(date1);//2018-12-31
//        LocalDate.parse("2018-11-31");//抛出异常
    }

    private static void test() {
        //当前日期
        LocalDate today = LocalDate.now();
        System.out.println(today);//2017-12-26
        //当前时间
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);//12:23:09.054
        //当前日期时间
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);//2017-12-26T12:23:09.054
        //构造指定日期
        LocalDate newYear = LocalDate.of(2018, 1, 1);
        System.out.println(newYear);//2018-01-01
        //解析日期字符串
        LocalDate date1 = LocalDate.parse("2018-12-31");
        System.out.println(date1);//2018-12-31
//        LocalDate.parse("2018-11-31");//抛出异常
        //15天后
        LocalDate date15 = today.plusDays(15);
        System.out.println(date15);//2018-01-10
        //获取年、月、日
        System.out.println(date15.getYear());//2018
        System.out.println(date15.getMonth());//JANUARY
        System.out.println(date15.getMonthValue());//1
        System.out.println(date15.getDayOfMonth());//10
        System.out.println(date15.getDayOfWeek());//WEDNESDAY
        System.out.println(date15.getDayOfYear());//10
        //用Date getYear()方法不能获取当前年份
        System.out.println(new Date().getYear());//117,不是我们想要的结果2017
    }
}
