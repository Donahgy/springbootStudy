package com.example.demo.sourcecode.beanDefinitionRegistryPostProcessor.pk2;


import com.example.demo.sourcecode.beanDefinitionRegistryPostProcessor.pk2.bean.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryProcessor implements PriorityOrdered, BeanDefinitionRegistryPostProcessor {

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Person.class);
        registry.registerBeanDefinition("person",beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
