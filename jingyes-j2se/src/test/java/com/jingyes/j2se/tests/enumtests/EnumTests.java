package com.jingyes.j2se.tests.enumtests;

import org.junit.Assert;
import org.junit.Test;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

import static com.jingyes.j2se.tests.enumtests.EnumOperType.*;

/**
 * Enum 枚举示例
 * @author jingyes
 * @date 2020/7/28
 */
public class EnumTests {
    @Test
    public void enumTests(){
        for(EnumOperType item: EnumOperType.values()){
            System.out.println("ordinal() ="+item.ordinal());
            System.out.println("name() ="+item.name());
            System.out.println(item);
        }
    }
    @Test
    public void compare() {
        EnumOperType operType = ADD;
        EnumOperType operType2 = ADD;
        Assert.assertTrue(operType.equals(ADD));
        Assert.assertTrue(operType == ADD);
        Assert.assertTrue(operType == operType2);
    }

    @Test
    public void enumMap() {
        Map<EnumOperType, String> map = new EnumMap<>(EnumOperType.class);
        map.put(DELETE, "user2");
        map.put(ADD, "user1");
        System.out.println(map);
        System.out.println(map.get(ADD));
    }

    @Test
    public void enumSet() {
        EnumSet operates = EnumSet.noneOf(EnumOperType.class);
        operates.add(ADD);
        System.out.println(operates);

        operates.addAll(EnumSet.of(MODIFY, MODIFY, DELETE));
        System.out.println(operates);


        operates = EnumSet.allOf(EnumOperType.class);
        System.out.println(operates);

        operates.removeAll(EnumSet.of(MODIFY));
        System.out.println(operates);
    }

    @Test
    public void test() {
        EnumSingleton instance = EnumSingleton.INSTANCE;
        EnumSingleton instance2 = EnumSingleton.INSTANCE;
        //是否指向同一实例
        Assert.assertEquals(instance, instance2);
        //设置属性值
        instance.setValue(100);
        Assert.assertEquals(100, instance2.getValue());
    }
}
