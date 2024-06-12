package com.jingyes.newfeature.java8.lambda;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jingyes
 * @date 2024/1/8
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        boolean result = map.replace(1, "a", "aa");
        System.out.println(result);//true
        result = map.replace(2, "b1", "bb");
        System.out.println(result);//false
    }
}
