package com.example.demo.parserpresetevent.starting;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;


public class MyApplicationStartingEventListener
    implements ApplicationListener<ApplicationStartingEvent>, Ordered
{

    private static final Map<String, String> SYSTEMS;

    static
    {
        Map<String, String> systems = new LinkedHashMap<>();
        systems.put("org.apache.logging.log4j.core.impl.Log4jContextFactory",
            "org.springframework.boot.logging.log4j2.Log4J2LoggingSystem");
        SYSTEMS = Collections.unmodifiableMap(systems);
    }

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event)
    {
        // 获取系统属性信息
        Properties properties = System.getProperties();
        properties.forEach((k, v) -> System.out.println(k + " -> " + v));
        // 更改springboot程序的日志系统，原先是slf4j，现在更改为log4j
        /*ClassLoader classLoader = event.getClass().getClassLoader();
        LoggingSystem loggingSystem = SYSTEMS.entrySet().stream().filter(
            entry -> ClassUtils.isPresent(entry.getKey(), classLoader)).map(
            entry -> get(classLoader, entry.getValue())).findFirst().orElseThrow(
            () -> new IllegalStateException("No suitable logging system located"));
        loggingSystem.beforeInitialize();*/
    }

    private static LoggingSystem get(ClassLoader classLoader, String loggingSystemClass) {
        try {
            Class<?> systemClass = ClassUtils.forName(loggingSystemClass, classLoader);
            Constructor<?> constructor = systemClass.getDeclaredConstructor(ClassLoader.class);
            constructor.setAccessible(true);
            return (LoggingSystem) constructor.newInstance(classLoader);
        }
        catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    @Override
    public int getOrder()
    {
        return Integer.MAX_VALUE;
    }
}
