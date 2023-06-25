package com.example.demo.myevent.pk1.listener;

import com.example.demo.myevent.pk1.event.ApplicationEvent;

public interface SmartApplicationListener extends ApplicationListener<ApplicationEvent> {

    void smartApplicationListenerMethod();

    boolean supportEventType(Class<? extends ApplicationEvent> eventType);
}
