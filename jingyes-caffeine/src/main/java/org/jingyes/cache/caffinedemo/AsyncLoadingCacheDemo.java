package org.jingyes.cache.caffinedemo;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Caffeine AsyncLoadingCache 异步自动加载缓存
 * @author jingyes
 */
public class AsyncLoadingCacheDemo {
    private static AsyncLoadingCache<Integer, Article> asyncLoadingCache =
            Caffeine.newBuilder()
                    .maximumSize(1000)
                    .expireAfterWrite(10, TimeUnit.MINUTES)
                    .buildAsync(
                            (key, executor) -> CompletableFuture.supplyAsync(() -> new Article(key), executor)
                    );

    public static void main(String[] args) {

        CompletableFuture<Article> userCompletableFuture = asyncLoadingCache.get(66);
        System.out.println(userCompletableFuture.join());//Article{id=66, title='title 66'}
    }
}
