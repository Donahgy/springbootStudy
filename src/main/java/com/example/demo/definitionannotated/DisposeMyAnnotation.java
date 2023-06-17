package com.example.demo.definitionannotated;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * 将自定义的注解实现类交给spring去管理，然后设置监听器监听spring容器启动完成的事件，
 * 就可以获取到spring的应用上下文从而获取到对应的bean对象，通过反射拿到每一个对象的
 * 注解信息，判断是否存在自定义的注解信息，如果存在就进行对应的逻辑处理
 */
@Component
public class DisposeMyAnnotation implements ApplicationListener<ApplicationStartedEvent> {


    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        ConfigurableListableBeanFactory beanFactory = event.getApplicationContext().getBeanFactory();
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            disposeDefineAnnotation(beanDefinitionName, beanFactory);
        }
    }

    public void disposeDefineAnnotation(String beanDefinitionName, ConfigurableListableBeanFactory beanFactory) {
        Class<? extends Object> aClass = beanFactory.getBean(beanDefinitionName).getClass();
        for (Annotation declaredAnnotation : aClass.getDeclaredAnnotations()) {
            if (declaredAnnotation instanceof MyDefinitionAnnotation) {
                System.out.println(((MyDefinitionAnnotation) declaredAnnotation).value());
            }
        }
    }
}

