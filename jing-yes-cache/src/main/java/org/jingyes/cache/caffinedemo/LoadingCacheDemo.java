package org.jingyes.cache.caffinedemo;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Caffeine LoadingCache示例，自动加载缓存
 *
 * @author chenjing
 */
public class LoadingCacheDemo {
    private static LoadingCache<Integer, Article> cache = Caffeine.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build(new CacheLoader<>() {
                @Override
                public @Nullable Article load(Integer id) {
                    return new Article(id);
                }
            });

    public static void main(String[] args) {
        System.out.println(cache.get(1));//Article{id=1, title='title 1'}

        //getIfPresent
        System.out.println(cache.getIfPresent(2));//null


        System.out.println(cache.getAll(List.of(10,20)));//{10=Article{id=10, title='title 10'}, 20=Article{id=20, title='title 20'}}
    }
}
