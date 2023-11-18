package org.jingyes.cache.caffinedemo.expiredemo;

import com.github.benmanes.caffeine.cache.*;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jingyes.cache.caffinedemo.Article;

import java.util.concurrent.TimeUnit;

/**
 * Caffeine refreshAfterWrite示例
 * @author chenjing
 */
public class RefreshAfterWriteDemo {
    public static void main(String[] args) throws InterruptedException {
        LoadingCache<Integer, Article> cache = Caffeine.newBuilder()
                .refreshAfterWrite(2, TimeUnit.SECONDS)
                .build(new CacheLoader<Integer, Article>() {
                    @Override
                    public @Nullable Article load(Integer integer) {
                        return new Article(integer);
                    }

                    @Override
                    public @Nullable Article reload(Integer key, Article oldValue) {
                        return new Article(key + 100);
                    }
                });

        cache.put(1, new Article(1));
        for (int i = 0; i < 3; i++) {
            System.out.println(cache.get(1));
            Thread.sleep(3000);
        }
    }
}
