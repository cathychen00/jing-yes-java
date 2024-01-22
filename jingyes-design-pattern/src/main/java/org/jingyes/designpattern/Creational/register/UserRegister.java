package org.jingyes.designpattern.Creational.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 陈敬
 * @date 2024/1/22
 */
public class UserRegister {
    private static UserRegister INSTANCE = new UserRegister();

    public static UserRegister getINSTANCE() {
        return INSTANCE;
    }

    private final Map<Integer, User> map;

    private UserRegister() {
        this.map = new ConcurrentHashMap<>();
    }

    public User registerUser(User user) {
        return this.map.put(user.getUserId(), user);
    }

    public User getUser(Integer userId) {
        return this.map.get(userId);
    }
}
