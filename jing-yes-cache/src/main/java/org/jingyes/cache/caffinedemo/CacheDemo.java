package org.jingyes.cache.caffinedemo;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

/**
 * Caffeine Cache
 *
 * @author chenjing
 * @date 2023-8-29
 */
public class CacheDemo {
    static Cache<Integer, Article> cache = Caffeine.newBuilder().build();

    public static void main(String[] args) {
        //get
        System.out.println(cache.get(1, x -> new Article(x)));//Article{id=1, title='title 1'}

        //getIfPresent
        System.out.println(cache.getIfPresent(2));//null

        //put
        cache.put(2, new Article(2));
        System.out.println(cache.getIfPresent(2));//Article{id=2, title='title 2'}
    }
}
