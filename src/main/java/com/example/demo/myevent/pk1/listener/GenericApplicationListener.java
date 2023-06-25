package com.example.demo.myevent.pk1.listener;

import com.example.demo.myevent.pk1.event.ApplicationEvent;
import org.springframework.core.ResolvableType;

public interface GenericApplicationListener extends ApplicationListener<ApplicationEvent>{


    boolean supportEventType(ResolvableType resolvableType);

    void genericApplicationListenerMethod();
}
