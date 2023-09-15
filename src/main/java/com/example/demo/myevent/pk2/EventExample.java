package com.example.demo.myevent.pk2;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.GenericApplicationContext;

public class EventExample {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        ApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        context.addApplicationListener(new MyEventListener());
        context.publishEvent(new MyEvent("Hello, Spring Event!"));
    }

    static class MyEvent extends ApplicationEvent {
        public MyEvent(Object source) {
            super(source);
        }
    }

    static class MyEventListener implements ApplicationListener<MyEvent> {
        @Override
        public void onApplicationEvent(MyEvent event) {
            System.out.println("MyEventListener received event: " + event.getSource());
        }
    }
}


