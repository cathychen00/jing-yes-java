package org.jingyes.cache.caffinedemo;

import com.github.benmanes.caffeine.cache.AsyncCache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Caffeine 异步缓存
 *
 * @author chenjing
 */
public class AsyncCacheDemo {
    static AsyncCache<Integer, Article> cache = Caffeine.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            //可以指定线程池
            .executor(Executors.newFixedThreadPool(8))
            .buildAsync();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //get 返回的是CompletableFuture
        CompletableFuture<Article> future = cache.get(1, x -> new Article(x));
        System.out.println(future.get());//Article{id=1, title='title 1'}
    }
}
