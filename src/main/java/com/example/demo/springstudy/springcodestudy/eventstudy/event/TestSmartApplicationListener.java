//package com.example.demo.springstudy.springcodestudy.eventstudy.event;
//
//import org.springframework.boot.context.event.ApplicationStartingEvent;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.event.SmartApplicationListener;
//
//
//public class TestSmartApplicationListener implements SmartApplicationListener
//{
//
//    private static final Class<?>[] EVENT_TYPE = {ApplicationStartingEvent.class};
//
//    @Override
//    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType)
//    {
//        for (Class<?> aClass : EVENT_TYPE)
//        {
//           return aClass.isAssignableFrom(eventType);
//        }
//        return false;
//    }
//
//    @Override
//    public void onApplicationEvent(ApplicationEvent event)
//    {
//        System.out.println("这是我的第三个监听了”ApplicationStartingEvent“事件的类....");
//    }
//}
