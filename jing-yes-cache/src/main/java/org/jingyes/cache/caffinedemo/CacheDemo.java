package org.jingyes.cache.caffinedemo;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

/**
 * Caffeine Cache 手动加载缓存
 *
 * @author chenjing
 * @date 2023-8-29
 */
public class CacheDemo {
    static Cache<Integer, Article> cache = Caffeine.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build();

    public static void main(String[] args) {
        //get
        System.out.println(cache.get(1, x -> new Article(x)));//Article{id=1, title='title 1'}

        //getIfPresent
        System.out.println(cache.getIfPresent(2));//null

        //put 设置缓存
        cache.put(2, new Article(2));
        System.out.println(cache.getIfPresent(2));//Article{id=2, title='title 2'}

        //invalidate 移除缓存
        cache.invalidate(2);
        System.out.println(cache.getIfPresent(2));//null
    }
}
