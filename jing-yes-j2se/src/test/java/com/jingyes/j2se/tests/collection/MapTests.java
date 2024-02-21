package com.jingyes.j2se.tests.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈敬
 * @date 2020/8/21
 */
public class MapTests {
    @Test
    public void iterator() {
        Map<String, Integer> map = new HashMap<>(5);
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);

        //推荐
        map.entrySet().forEach(x -> {
            System.out.println(x.getKey() + "=" + x.getValue());
        });

        //不推荐，实际遍历了两次
        map.keySet().forEach(key -> {
            System.out.println(key + "=" + map.get(key));
        });
    }
}
