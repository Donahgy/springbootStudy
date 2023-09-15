package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@EnableAsync
@MapperScan("com.example.demo.redisson.mapper")
@EnableScheduling
public class DemoApplication
{

    public static void main(String[] args)
    {
        // 测试
        SpringApplication.run(DemoApplication.class, args);
    }

}
