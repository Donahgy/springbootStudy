//package com.example.demo.myevent.testspringstartingevent;
//
//import org.springframework.boot.context.event.ApplicationStartingEvent;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.event.SmartApplicationListener;
//import org.springframework.context.ApplicationListener;
//
///**
// * {@link SmartApplicationListener}是spring框架中一个事件监听器接口，它是{@link ApplicationListener}
// * 的一个扩展接口，提高了更高级别的事件监听器。
// * 与普通的{@link ApplicationListener}不同，{@link SmartApplicationListener}接口添加了一个supportEventType方法
// * 和一个supportSourceType方法。用来判断当前监听器是否支持特定类型的事件和特定来源的事件。这样可以优化事件的处理过程，避免
// * 不必要的事件处理和逻辑判断。
// */
//public class MyDefineStartingEventListener implements SmartApplicationListener {
//
//    @Override
//    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
//        return ApplicationStartingEvent.class.isAssignableFrom(eventType);
//    }
//
//    @Override
//    public void onApplicationEvent(ApplicationEvent event) {
//        System.out.println("springboot项目开始启动...");
//    }
//}
