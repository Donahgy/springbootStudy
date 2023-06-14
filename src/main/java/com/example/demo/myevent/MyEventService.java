package com.example.demo.myevent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MyEventService {

    @Resource
    ApplicationContext applicationContext;

    @Resource
    SimpleApplicationEventMulticaster simpleApplicationEventMulticaster;

    public void myMethod() {

        // 通过applicationContext发布的事件最终还是会调用SimpleApplicationEventMulticaster中的multicastEvent方法去发布一个事件，
        // 所以他的底层实现还是下面的这行代码
        applicationContext.publishEvent(new MyselfEvent("我自己的事件"));
        simpleApplicationEventMulticaster.multicastEvent(new MyselfEvent("我自己的事件..."));
    }

}
