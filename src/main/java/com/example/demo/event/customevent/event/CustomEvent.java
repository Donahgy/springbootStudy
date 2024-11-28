package com.example.demo.event.customevent.event;

import org.springframework.context.ApplicationEvent;


public class CustomEvent extends ApplicationEvent
{
    /**
     * Create a new {@code ApplicationEvent}.
     */
    public CustomEvent(Object source)
    {
        super(source);
    }

}
