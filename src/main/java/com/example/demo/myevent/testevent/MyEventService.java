package com.example.demo.myevent.testevent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MyEventService {

    @Resource
    ApplicationContext applicationContext;

    @Resource
    SimpleApplicationEventMulticaster simpleApplicationEventMulticaster;
    /**
     * applicationContext.publishEvent方法会调用{@link AbstractApplicationContext#publishEvent(Object, ResolvableType)}方法
     * 最终还是会调用{@link ApplicationEventMulticaster#multicastEvent(ApplicationEvent, ResolvableType)}方法去发布一个事件
     * 底层最终都是通过{@link SimpleApplicationEventMulticaster#multicastEvent(ApplicationEvent, ResolvableType)}}发布事件
     */
    public void myMethod() {
        applicationContext.publishEvent(new MyselfEvent("我自己的事件"));
        simpleApplicationEventMulticaster.multicastEvent(new MyselfEvent("我自己的事件..."));
    }

}
