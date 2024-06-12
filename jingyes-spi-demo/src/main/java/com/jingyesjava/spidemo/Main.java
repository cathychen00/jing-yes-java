package com.jingyesjava.spidemo;


import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * SPI(Service Provider Interface) 简单示例
 * 声明文件在META-INF/services目录
 *
 * @author jingyes
 * @date 2024/4/18
 */
public class Main {
    public static void main(String[] args) {
        ServiceLoader<Logger> s = ServiceLoader.load(Logger.class);
        Iterator<Logger> iterator = s.iterator();

        //Logger可以加载多种实现，配置在META-INF/services中
        while (iterator.hasNext()) {
            Logger logger = iterator.next();
            logger.info("执行时间...");
            logger.error("异常");
        }
    }
}