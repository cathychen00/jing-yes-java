package com.jingyes.newfeature.java17;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author 陈敬
 * @date 2024/2/19
 */
public class NumberFormatDemo {
    public static void main(String[] args) {
        NumberFormat format=NumberFormat.getCompactNumberInstance(Locale.CHINA, NumberFormat.Style.SHORT);
        System.out.println(format.format(1000));
        System.out.println(format.format(100000));
        System.out.println(format.format(1000000));
        System.out.println(format.format(10000000));
        System.out.println(format.format(100000000));

        format=NumberFormat.getCompactNumberInstance(Locale.CHINA, NumberFormat.Style.LONG);
        System.out.println(format.format(1000));
        System.out.println(format.format(100000));
        System.out.println(format.format(1000000));
        System.out.println(format.format(10000000));
        System.out.println(format.format(100000000));

        format=NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.SHORT);
        System.out.println(format.format(1000));
        System.out.println(format.format(100000));
        System.out.println(format.format(1000000));
        System.out.println(format.format(10000000));
        System.out.println(format.format(100000000));

        format=NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.LONG);
        System.out.println(format.format(1000));
        System.out.println(format.format(100000));
        System.out.println(format.format(1000000));
        System.out.println(format.format(10000000));
        System.out.println(format.format(100000000));
    }
}
