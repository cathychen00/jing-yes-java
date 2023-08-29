package org.jingyes.cache.caffinedemo;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

/**
 * Caffeine Cache
 * @author chenjing
 * @date 2023-8-29
 */
public class ArticleCache {
    static Cache<Integer, String> cache = Caffeine.newBuilder().build();

    public static void main(String[] args) {
        //get
        System.out.println(cache.get(1, ArticleCache::getTitleById));//title 1

        //getIfPresent
        System.out.println(cache.getIfPresent(2));//null

        //put
        cache.put(2, "test 2");
        System.out.println(cache.getIfPresent(2));
    }

    private static String getTitleById(Integer id) {
        return "title " + id;
    }
}
