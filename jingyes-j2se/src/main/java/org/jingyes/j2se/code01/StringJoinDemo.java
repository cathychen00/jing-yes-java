package org.jingyes.j2se.code01;

import java.util.StringJoiner;

/**
 * 字符串拼接
 *
 * @author jingyes
 * @date 2021/3/30
 */
public class StringJoinDemo {
    public static void main(String[] args) {
        String[] names = {"Bob", "Alice", "Grace"};
        //用StringJoiner拼接字符串时，还可以额外附加一个“开头”和“结尾”。
        StringJoiner sj = new StringJoiner(", ", "Hello ", "!");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());


        //直接使用string.join连接
        String s = String.join(", ", names);
        System.out.println(s);
    }
}
