package com.example.demo.event.executor.event;

import org.springframework.context.ApplicationEvent;


public class MyCustomEvent extends ApplicationEvent
{
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyCustomEvent(Object source)
    {
        super(source);
    }
}
