package org.jingyes.cache.caffinedemo.expiredemo;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.jingyes.cache.caffinedemo.Article;

/**
 * 测试Caffeine基于空间的驱逐策略
 *
 * @author chenjing
 */
public class MaxSizeExpire {
    public static void main(String[] args) {
        System.out.println("测试基于容量过期的缓存");
        Integer size = 10;
        Cache<Integer, Article> cache = Caffeine.newBuilder()
                .maximumSize(size)
                .recordStats()
                .build();
        cache.put(1, new Article(1));
        System.out.println("放入一条数据，获取看看");
        System.out.println(cache.getIfPresent(1));//Article{id=1, title='title 1'}

        System.out.println("放入" + size + "条数据");
        for (int i = 2; i <= size + 5; i++) {
            cache.put(i, new Article(i));
        }

        System.out.println("再打印第一条数据看看");
        System.out.println(cache.getIfPresent(1));//Article{id=1, title='title 1'}

        //打印一下缓存状态
        System.out.println(cache.stats());//CacheStats{hitCount=2, missCount=0, loadSuccessCount=0, loadFailureCount=0, totalLoadTime=0, evictionCount=5, evictionWeight=5}
    }
}
