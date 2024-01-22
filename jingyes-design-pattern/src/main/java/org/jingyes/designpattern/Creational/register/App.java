package org.jingyes.designpattern.Creational.register;

/**
 * @author 陈敬
 * @date 2024/1/22
 */
public class App {
    public static void main(String[] args) {
        UserRegister register = UserRegister.getINSTANCE();
        register.registerUser(new User(1, "小王"));
        register.registerUser(new User(2, "小李"));
        System.out.println(register.getUser(1).toString());
    }
}
