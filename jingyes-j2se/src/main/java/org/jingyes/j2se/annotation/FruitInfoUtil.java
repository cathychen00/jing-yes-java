package org.jingyes.j2se.annotation;

import java.lang.reflect.Field;

/**
 * @author jingyes
 * @date 2021/4/6
 * 注解实例
 */
public class FruitInfoUtil {
    public static void main(String[] args) {
        getFruitInfo(Apple.class);
    }

    public static void getFruitInfo(Class<?> clz) {
        String result = "供应商信息：";
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider annotation = field.getAnnotation(FruitProvider.class);
                System.out.println("id=" + annotation.id());
                System.out.println("name=" + annotation.name());
                System.out.println("address=" + annotation.address());
            }
        }
    }
}
