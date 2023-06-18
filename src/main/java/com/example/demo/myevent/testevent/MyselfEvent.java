package com.example.demo.myevent.testevent;

import org.springframework.context.ApplicationEvent;

public class MyselfEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyselfEvent(Object source) {
        super(source);
    }
}
