package com.example.demo.event.executor.publisher;

import com.example.demo.event.executor.event.MyCustomEvent;
import com.example.demo.event.executor.listener.MyListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.Executor;


@Component
public class MyCustomPublisher extends SimpleApplicationEventMulticaster
{

    @Resource
    ApplicationContext applicationContext;

    public void publishEvent(MyCustomEvent event)
    {
        this.setTaskExecutor(taskExecutor());
        this.multicastEvent(event);
    }

    @Override
    public void multicastEvent(ApplicationEvent event)
    {
        multicastEvent(event, resolveDefaultEventType(event));
    }

    @Override
    public void multicastEvent(final ApplicationEvent event,
                               @Nullable
                               ResolvableType eventType)
    {
        ResolvableType type = (eventType != null ? eventType : resolveDefaultEventType(event));
        Executor executor = getTaskExecutor();
        for (ApplicationListener<?> listener : getApplicationListeners(event, type))
        {
            if (executor != null)
            {
                executor.execute(() -> invokeListener(listener, event));
            }
            else
            {
                invokeListener(listener, event);
            }
        }
    }

    private ResolvableType resolveDefaultEventType(ApplicationEvent event)
    {
        return ResolvableType.forInstance(event);
    }

    protected Collection<ApplicationListener<?>> getApplicationListeners(ApplicationEvent event,
                                                                         ResolvableType eventType)
    {

        Set<ApplicationListener<?>> listeners = new HashSet<>();
        MyListener myListener = applicationContext.getBean(MyListener.class);
        listeners.add(myListener);
        return listeners;
    }

    public Executor taskExecutor()
    {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.setThreadNamePrefix("Async-");
        executor.initialize();
        return executor;
    }
}
