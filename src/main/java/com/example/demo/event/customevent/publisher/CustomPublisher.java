package com.example.demo.event.customevent.publisher;

import com.example.demo.event.customevent.event.CustomEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CustomPublisher
{
    @Resource
    ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent(CustomEvent event)
    {
        applicationEventPublisher.publishEvent(event);
    }
}
