package com.jingyes.newfeature;

/**
 * instanceof语法升级，能直接判断类型并进行强制转换
 *
 * @author 陈敬
 * @date 2024/2/19
 */
public class InstanceOfDemo {
    public static void main(String[] args) {
        Object obj = new User(1, "jingyes");
        //老语法
        if (obj instanceof User) {
            User user = (User) obj;
            System.out.println(user.userName());
        }

        //新语法
        if (obj instanceof User user) {
            System.out.println(user.userName());//输出jingyes
        }

        if (obj instanceof User user && user.userId() == 1) {
            System.out.println("找到id=1的用户啦");
        }
    }
}
