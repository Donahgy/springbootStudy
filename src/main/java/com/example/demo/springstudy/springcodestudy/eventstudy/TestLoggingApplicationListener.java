//package com.example.demo.springstudy.springcodestudy.eventstudy;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.context.event.*;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.event.ContextClosedEvent;
//import org.springframework.context.event.GenericApplicationListener;
//import org.springframework.core.ResolvableType;
//import org.springframework.boot.context.logging.LoggingApplicationListener;
//
///**
// * 该方法的监听事件类型类似于{@link LoggingApplicationListener},1
// * 通过实现 {@link GenericApplicationListener}接口，从而重写
// * {@link GenericApplicationListener#supportsEventType}方法，
// * 确定该监听器监听的事件类型，从而在{@link TestLoggingApplicationListener#onApplicationEvent}
// * 方法中，根据事件的实际类型从而进行接下来的逻辑处理
// */
//public class TestLoggingApplicationListener implements GenericApplicationListener {
//
//    private static final Class<?>[] SOURCE_TYPES = { SpringApplication.class, ApplicationContext.class };
//
//    private static final Class<?>[] EVENT_TYPES = { ApplicationStartingEvent.class,
//            ApplicationEnvironmentPreparedEvent.class, ApplicationPreparedEvent.class, ContextClosedEvent.class,
//            ApplicationFailedEvent.class ,ApplicationStartedEvent.class};
//
//    @Override
//    public boolean supportsEventType(ResolvableType eventType) {
//        return isAssignableFrom(eventType.getRawClass(), EVENT_TYPES);
//    }
//
//    @Override
//    public boolean supportsSourceType(Class<?> sourceType) {
//        return isAssignableFrom(sourceType, SOURCE_TYPES);
//    }
//
//    @Override
//    public void onApplicationEvent(ApplicationEvent event) {
//        if (event instanceof ApplicationStartingEvent)
//        {
//            System.out.println("spring应用程序正在开始启动...");
//        }
//        if (event instanceof ApplicationStartedEvent)
//        {
//            System.out.println("spring应用程序启动完成...");
//        }
//    }
//
//    private boolean isAssignableFrom(Class<?> type, Class<?>... supportedTypes) {
//        if (type != null) {
//            for (Class<?> supportedType : supportedTypes) {
//                if (supportedType.isAssignableFrom(type)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//}
