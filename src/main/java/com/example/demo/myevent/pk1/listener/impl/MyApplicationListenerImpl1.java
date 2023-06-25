package com.example.demo.myevent.pk1.listener.impl;

import com.example.demo.myevent.pk1.listener.GenericApplicationListener;
import com.example.demo.myevent.pk1.event.impl.ApplicationEventImpl1;
import org.springframework.core.ResolvableType;

public class MyApplicationListenerImpl1 implements GenericApplicationListener {


    @Override
    public boolean supportEventType(ResolvableType resolvableType) {
        return resolvableType.getRawClass().isAssignableFrom(ApplicationEventImpl1.class);
    }

    @Override
    public void genericApplicationListenerMethod() {

    }
}
