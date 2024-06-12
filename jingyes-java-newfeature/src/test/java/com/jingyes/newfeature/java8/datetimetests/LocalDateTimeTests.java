package com.jingyes.newfeature.java8.datetimetests;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * Local 简化了日期时间的处理，没有时区的问题
 *
 * @author jingyes
 * @date 18/1/2
 */
public class LocalDateTimeTests {
    @Test
    public void testDate() {
        //Date很多方法已经过时，不推荐使用
        Date date = new Date();
        System.out.println(date);//Tue Feb 20 10:06:53 CST 2024
        //getYear，不是返回当前年份
        System.out.println(date.getYear());//124
    }

    @Test
    public void testLocalDate() {
        //当前日期
        LocalDate today = LocalDate.now();
        System.out.println(today);//2024-02-20
        //构造指定日期
        LocalDate newYear = LocalDate.of(2024, 1, 1);
        System.out.println(newYear);//2024-01-01
        //15天后
        LocalDate date15 = today.plusDays(15);
        System.out.println(date15);//2024-03-06
        //获取年、月、日
        System.out.println(date15.getYear());//2024
        System.out.println(date15.getMonth());//MARCH
        System.out.println(date15.getMonthValue());//3
        System.out.println(date15.getDayOfMonth());//6
        System.out.println(date15.getDayOfWeek());//WEDNESDAY
        System.out.println(date15.getDayOfYear());//66
    }

    @Test
    public void testLocalTime() {
        //当前时间
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);//12:23:09.054
        //当前日期时间
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);//2024-02-20T12:23:09.054
    }

    @Test
    public void parseDate() {
        //解析日期字符串
        LocalDate date1 = LocalDate.parse("2018-12-31");
        System.out.println(date1);//2018-12-31
//        LocalDate.parse("2018-11-31");//抛出异常
    }

    @Test
    public void printCalendar() {
        System.out.println("一 二 三 四 五 六 日");
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        LocalDate date = today.minusDays(today.getDayOfMonth() - 1);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        for (int i = 0; i < dayOfWeek.getValue() - 1; i++) {
            System.out.print("  ");
        }
        while (date.getMonthValue() == month) {
            System.out.print(" " + date.getDayOfMonth());
            if (date.getDayOfMonth() == today.getMonthValue()) {
                System.out.print("*");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
    }

    @Test
    public void test() {
        //当前日期
        LocalDate today = LocalDate.now();
        System.out.println(today);//2024-02-20
        //当前时间
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);//12:23:09.054
        //当前日期时间
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);//2024-02-20T12:23:09.054
        //构造指定日期
        LocalDate newYear = LocalDate.of(2018, 1, 1);
        System.out.println(newYear);//2018-01-01
        //解析日期字符串
        LocalDate date1 = LocalDate.parse("2018-12-31");
        System.out.println(date1);//2018-12-31
//        LocalDate.parse("2018-11-31");//抛出异常
        //15天后
        LocalDate date15 = today.plusDays(15);
        System.out.println(date15);//2024-03-06
        //获取年、月、日
        System.out.println(date15.getYear());//2024
        System.out.println(date15.getMonth());//MARCH
        System.out.println(date15.getMonthValue());//3
        System.out.println(date15.getDayOfMonth());//6
        System.out.println(date15.getDayOfWeek());//WEDNESDAY
        System.out.println(date15.getDayOfYear());//66
        //用Date getYear()方法不能获取当前年份
        System.out.println(new Date().getYear());//124,不是我们想要的结果2017
    }

    @Test
    public void TemporalAdjusters() {
        LocalDate now = LocalDate.now();
        LocalDate firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfMonth);

        LocalDate lastMonday = now.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));
        System.out.println(lastMonday);

        //计算5月第二个周日
        LocalDate motherDay = LocalDate.parse("2024-05-01").with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SUNDAY));
        System.out.println(motherDay);
    }

    @Test
    public void diff_days() {
        LocalDate date1 = LocalDate.parse("2024-04-18");
        LocalDate date2 = LocalDate.parse("2024-05-20");
        System.out.println(date2.toEpochDay() - date1.toEpochDay());
    }
}
