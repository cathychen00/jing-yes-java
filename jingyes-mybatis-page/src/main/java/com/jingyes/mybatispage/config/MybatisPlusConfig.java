package com.jingyes.mybatispage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.jingyes.mybatispage.mapper")
public class MybatisPlusConfig {
}