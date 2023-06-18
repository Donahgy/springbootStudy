package com.example.demo.myevent.environmentevent;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
 *  获取配置文件的信息时需要监听{@link ApplicationEnvironmentPreparedEvent}事件，因为spring-boot的
 *  配置文件的加载是通过{@link  ConfigFileApplicationListener}监听器加载的，而该监听器监听的事件就是
 *  {@link ApplicationEnvironmentPreparedEvent}事件，同时因为该事件会在spring容器启动之前发布，所以
 *  不能通过{@link Component}注解获取。此时需要通过在配置spring.factories文件中配置对应的bean，使其
 *  在spring容器启动之前创建对应的bean实例，这样就能获取到对应的environment对象，从而获取对应的配置信息
 */
public class ListenerEnvironmentEvent implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        YmlUtil.environment = event.getEnvironment();
    }
}
