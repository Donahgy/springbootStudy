package com.sourcecode.study.event.pk2.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class MyCustomListener
{

    @EventListener
    public void handleEvent(ApplicationStartedEvent myCustomEvent)
    {
        System.out.println("spring容器启动完成...");
    }
}
