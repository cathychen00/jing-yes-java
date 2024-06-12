package org.jingyes.j2se.annotation;

import java.lang.annotation.*;

/**
 * @author jingyes
 * @date 2021/4/6
 */
//该注解被保留的级别
@Retention(RetentionPolicy.RUNTIME)
//注解所修饰的对象范围
@Target(ElementType.FIELD)
//表明这个注解应该被javadoc工具记录
@Documented
public @interface FruitProvider {
    public int id() default -1;

    public String name() default "";

    public String address() default "";
}
