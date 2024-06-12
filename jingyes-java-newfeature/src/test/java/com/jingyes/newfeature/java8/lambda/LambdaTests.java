package com.jingyes.newfeature.java8.lambda;

import com.jingyes.newfeature.common.Converter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author jingyes
 * @date 2021/1/20
 */
public class LambdaTests {
    @Test
    public void lambda_expression() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        names.sort((a, b) -> a.compareTo(b));
    }

    /**
     * “函数式接口”是指仅仅只包含一个抽象方法,但是可以有多个非抽象方法
     */
    @Test
    public void functional_interface() {
        Converter<String, Integer> converter = s -> Integer.valueOf(s);
        Integer result = converter.convert("11");
        Assert.assertEquals(11, result, 1);
    }

    @Test
    public void method_ref() {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer result = converter.convert("11");
        Assert.assertEquals(11, result, 1);
    }

    @Test
    public void lambda_scope() {
        //该处num用于lambda表达式，可以不加final关键字，但是后面不能被修改
        int num = 10;
        Converter<String, Integer> converter = s -> Integer.valueOf(s) * num;
        Integer result = converter.convert("11");
        Assert.assertEquals(110, result, 1);

        //Error:(40, 74) java: 从lambda 表达式引用的本地变量必须是最终变量或实际上的最终变量
//        num=5;
    }
}