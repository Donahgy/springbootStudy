package com.example.demo.event.customevent.controller;

import com.example.demo.event.customevent.event.CustomEvent;
import com.example.demo.event.customevent.event.Source;
import com.example.demo.event.customevent.publisher.CustomPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class TestController
{

    @Resource
    CustomPublisher customPublisher;

    @RequestMapping("/test")
    public String test()
    {
        Source source = new Source();
        source.setNum(1);
        CustomEvent customEvent = new CustomEvent(source);
        customPublisher.publishEvent(customEvent);
        System.out.println(Thread.currentThread().getName());
        return "test";
    }

}
