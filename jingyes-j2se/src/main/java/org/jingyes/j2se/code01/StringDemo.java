package org.jingyes.j2se.code01;

/**
 * @author jingyes
 * @date 2021/3/30
 */
public class StringDemo {
    public static void main(String[] args) {
        //子串
        String s = "你好，今天是2017年12月24日，圣诞快乐！！";
        String date = s.substring(6, 17);
        System.out.println(date);//输出：2017年12月24日
        //拼接
        String s2 = String.join("、", "JAVA核心技术", "JAVA编程思想", "SpringBoot");
        System.out.println(s2);//输出：JAVA核心技术、JAVA编程思想、SpringBoot
        //比较： 当创建 String 类型的对象时，虚拟机会在常量池中查找有没有已经存在的值和要创建的值相同的对象，如果有就把它赋给当前引用。如果没有就在常量池中重新创建一个 String 对象。
        // 所以一定不要使用==运算符检测两个字符串是否相等！这个运算符只能够确定两个字符串是否放置在同一个位置上。
        // 如果虚拟机始终将相同的字符串共享，就可以使用==运算符检测是否相等。但实际上只有字符串常量是共享的，而+或substring等操作产生的结果并不是共享的。
        String s3 = "abc";
        String s4 = "abc";
        String s5 = new String("abc");
        String s6 = new String("abc");
        System.out.println(s3 == s4);//true
        System.out.println(s3.equals(s4));//true
        System.out.println(s5 == s6);//false
        System.out.println(s5.equals(s6));//true

        //避免NP
        String s7 = null;
        System.out.println(s7 != null && s7.equals("null"));
        System.out.println("null".equals(s7));
    }
}
