package com.example.demo;

import com.example.demo.myevent.MyEventService;
import org.junit.Test;
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
    }
}
