package com.example.demo.myevent.pk1.listener;

import com.example.demo.myevent.pk1.event.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.context.event.AbstractApplicationEventMulticaster;
import com.example.demo.myevent.pk1.listener.impl.MyApplicationListenerImpl1;
import com.example.demo.myevent.pk1.listener.impl.MyApplicationListenerImpl2;
import com.example.demo.myevent.pk1.listener.impl.MyApplicationListenerImpl3;

public class GenericApplicationListenerAdapter implements GenericApplicationListener, SmartApplicationListener {


    private final ApplicationListener<ApplicationEvent> delegate;

    @Nullable
    private final ResolvableType declaredEventType;


    /**
     * 处理当前监听器的时候会解析该监听器对应的事件类型，
     * 如果当前监听器实现了{@link ApplicationListener}并且指明了对应的事件泛型则在处理时会直接返回该监听器支持的事件类型，这也是常用的监
     * 听器的实现方式比如{@link MyApplicationListenerImpl3}的形式；
     * 另外一种方式就是监听器实现了{@link GenericApplicationListener}接口，此时不会走该适配器方法，会直接调用实现类的supportsEventType去判断当前
     * 监听器支持的事件类型，比如{@link MyApplicationListenerImpl1}的实现；
     * 还有一种方式就是监听器实现了{@link SmartApplicationListener}接口，此时会走该方法去创建对应的适配器类型，但是通过getDeclaredEventType
     * 返回的事件类型并不是真实的事件类型而是事件的顶层实现既{@link ApplicationEvent}对象，所以还是会走{@link AbstractApplicationEventMulticaster}的
     * supportsEventType方法，真实的事件类型就是{@link AbstractApplicationEventMulticaster.supportsEvent(listener,eventType,sourceType)}第二个参数
     *比如{@link MyApplicationListenerImpl2}的实现；
     * @param delegate
     */
    public GenericApplicationListenerAdapter(ApplicationListener<?> delegate) {
        Assert.notNull(delegate, "Delegate listener must not be null");
        this.delegate = (ApplicationListener<ApplicationEvent>) delegate;
        this.declaredEventType = getDeclaredEventType(this.delegate);
    }

    private static ResolvableType getDeclaredEventType(ApplicationListener<?> delegate) {
        return getDeclaredEventType(delegate.getClass());
    }

    private static ResolvableType getDeclaredEventType(Class<?> listenerType) {
        ResolvableType eventType = ResolvableType.forClass(listenerType).as(ApplicationListener.class).getGeneric();
        return eventType;
    }

    @Override
    public boolean supportEventType(ResolvableType eventType) {
        if (this.delegate instanceof SmartApplicationListener) {
            Class<? extends ApplicationEvent> eventClass = (Class<? extends ApplicationEvent>) eventType.resolve();
            return (eventClass != null && ((SmartApplicationListener) this.delegate).supportEventType(eventClass));
        } else {
            return (this.declaredEventType == null || this.declaredEventType.isAssignableFrom(eventType));
        }
    }

    @Override
    public void genericApplicationListenerMethod() {
        System.out.println("genericApplicationListenerMethod被调用了...");
    }

    @Override
    public void smartApplicationListenerMethod() {
        System.out.println("smartApplicationListenerMethod被调用了...");
    }

    @Override
    public boolean supportEventType(Class<? extends ApplicationEvent> eventType) {
        return supportEventType(ResolvableType.forClass(eventType));
    }
}
