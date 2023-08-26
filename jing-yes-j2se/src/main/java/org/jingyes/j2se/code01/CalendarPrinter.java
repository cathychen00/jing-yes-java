package org.jingyes.j2se.code01;

import java.time.DayOfWeek;
import java.time.LocalDate;

/** 打印当前月份的日历
 * @author chenjing
 * @date 2023-08-26
 */
public class CalendarPrinter {
    public static void main(String[] args) {
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
            if (date.getDayOfMonth() == today.getDayOfMonth()) {
                System.out.print("*");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
    }
}
