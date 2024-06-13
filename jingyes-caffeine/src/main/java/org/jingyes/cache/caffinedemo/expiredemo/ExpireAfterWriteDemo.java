package org.jingyes.cache.caffinedemo.expiredemo;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import org.jingyes.cache.caffinedemo.Article;

import java.util.concurrent.TimeUnit;

/**
 * Caffeine expireAfterWrite
 * @author jingyes
 */
public class ExpireAfterWriteDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("测试基于时间过期的缓存");
        Integer seconds = 5;
        Integer size = 5;
        Cache<Integer, Article> cache = Caffeine.newBuilder()
                //基于时间过期
                .expireAfterWrite(seconds, TimeUnit.SECONDS)
                //监控缓存移除
                .removalListener((Integer key, Article value, RemovalCause cause) ->
                        System.out.printf("移除key %s，原因是 %s %n", key, cause))
                .build();

        System.out.println("放入" + size + "条数据");
        for (int i = 1; i <= size; i++) {
            cache.put(i, new Article(i));
            System.out.println(cache.getIfPresent(i));
        }

        System.out.println("sleep 10 seconds");
        Thread.sleep(10000);

        for (int i = 1; i <= size; i++) {
            cache.put(i, new Article(i));
            System.out.println(cache.getIfPresent(i));
        }
    }
}
