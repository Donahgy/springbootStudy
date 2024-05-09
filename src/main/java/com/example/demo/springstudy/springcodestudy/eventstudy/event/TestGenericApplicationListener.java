//package com.example.demo.springstudy.springcodestudy.eventstudy.event;
//
//import org.springframework.boot.context.event.ApplicationStartingEvent;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.event.GenericApplicationListener;
//import org.springframework.core.ResolvableType;
//
//import java.util.Objects;
//
//
///**
// * 这种方式通常用于spring容器还没有完全启动时，创建bena的方式是通过spring.factories文件中获取对应的
// * Class信息，从而去创建。
// */
//public class TestGenericApplicationListener implements GenericApplicationListener
//{
//
//
//    private static final Class<?>[] EVENT_TYPE = {ApplicationStartingEvent.class};
//
//    @Override
//    public boolean supportsEventType(ResolvableType eventType)
//    {
//        for (Class<?> aClass : EVENT_TYPE)
//        {
//            return aClass.isAssignableFrom(Objects.requireNonNull(eventType.getRawClass()));
//        }
//        return false;
//    }
//
//    @Override
//    public void onApplicationEvent(ApplicationEvent event)
//    {
//        System.out.println("这是我的第二个自定义监听”ApplicationStartingEvent“事件的类....");
//    }
//}
