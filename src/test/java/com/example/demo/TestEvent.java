package com.example.demo;

import com.example.demo.myevent.environmentevent.YmlUtil;
import com.example.demo.myevent.testevent.MyEventService;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestEvent {

    @Resource
    MyEventService myEventService;

    @org.junit.jupiter.api.Test
    public void test()
    {
        myEventService.myMethod();
        System.out.println(YmlUtil.getSystemEnvironment());
        System.out.println("---------------------------------------------------");
        System.out.println(YmlUtil.getSystemEnvironment());
        System.out.println("---------------------------------------------------");
        System.out.println(YmlUtil.getString("spring.redis.redisson.file"));
    }
}
