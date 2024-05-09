package com.sourcecode.study.event.pk1.publisher;

import com.sourcecode.study.event.pk1.event.MyCustomEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class MyCustomEventPublisher
{

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     *  {@link ApplicationEventPublisher#publishEvent(Object)}发布事件的原理其实本质上还是通过事件多播器发布事件，其最终还是会调用
     *  {@link SimpleApplicationEventMulticaster#multicastEvent(ApplicationEvent)}方法完成事件的发布。本质上与spring内置的事件发布机制相同
     */
    public void publishMyEvent()
    {
        applicationEventPublisher.publishEvent(new MyCustomEvent(this));
    }
}
