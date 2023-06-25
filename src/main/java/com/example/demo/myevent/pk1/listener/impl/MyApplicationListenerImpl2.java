package com.example.demo.myevent.pk1.listener.impl;

import com.example.demo.myevent.pk1.event.ApplicationEvent;
import com.example.demo.myevent.pk1.event.impl.ApplicationEventImpl2;
import com.example.demo.myevent.pk1.listener.SmartApplicationListener;

public class MyApplicationListenerImpl2 implements SmartApplicationListener {


    @Override
    public void smartApplicationListenerMethod() {

    }

    @Override
    public boolean supportEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEventImpl2.class.isAssignableFrom(eventType);
    }
}
