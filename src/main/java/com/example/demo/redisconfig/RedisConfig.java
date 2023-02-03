package com.example.demo.redisconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Random;


@PropertySource(value = "classpath:redis.yml")
@Configuration
public class RedisConfig
{
    public static void main(String[] args)
    {
        for (int i = 0; i < 20; i++)
        {
            int j = new Random().nextInt(2);
            System.out.println(j);
        }

    }
}
