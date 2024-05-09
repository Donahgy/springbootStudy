package com.example.demo.myevent.pk3;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class MyCustomListener
{

    @EventListener
    public void handleEvent(ApplicationStartingEvent myCustomEvent)
    {
        System.out.println("spring容器开始启动...");
    }
}
