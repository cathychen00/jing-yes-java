package com.jingyes.newfeature;

import com.jingyes.newfeature.common.User;

/**
 * record声明的类，具备这些特点：
 * 它是一个final类
 * 自动实现equals、hashCode、toString函数
 * 成员变量均为public属性
 *
 * @author 陈敬
 * @date 2024/2/19
 */
public class RecordDemo {
    public static void main(String[] args) {
        User user = new User(1, "jingyes");
        System.out.println(user);

        User user2 = new User(2, "test");
        System.out.println(user2);

        System.out.println(user.equals(user2));
    }
}
