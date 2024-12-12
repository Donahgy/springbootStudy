package com.example.demo.event.executor.controller;

import com.example.demo.event.executor.event.MyCustomEvent;
import com.example.demo.event.executor.publisher.MyCustomPublisher;
import com.example.demo.event.executor.source.MySourceObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Controller
@RestController
public class MyController
{

    @Resource
    MyCustomPublisher myCustomPublisher;

    @RequestMapping(value = "/myController")
    public String testExecutor()
    {
        MySourceObject mySourceObject = new MySourceObject();
        mySourceObject.setName("潘东");
        MyCustomEvent myCustomEvent = new MyCustomEvent(mySourceObject);
        myCustomPublisher.publishEvent(myCustomEvent);
        return mySourceObject.getName();
    }
}
