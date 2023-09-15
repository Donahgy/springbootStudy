package com.example.demo.sourcecode.beanDefinitionRegistryPostProcessor.pk1;

import com.example.demo.sourcecode.beanDefinitionRegistryPostProcessor.pk1.bean.MyBeanClass;
import com.example.demo.sourcecode.beanDefinitionRegistryPostProcessor.pk1.bean.MyBeanClassWithoutComponent;
import com.example.demo.sourcecode.beanDefinitionRegistryPostProcessor.pk2.bean.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {



    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {


        // 修改bean的名称
        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(MyBeanDefinitionRegistryPostProcessor.class).getBeanDefinition();
        registry.registerBeanDefinition("myBean",beanDefinition);

        // 通过beanDefinitionRegistryPostProcessor将一个没有添加的注解的类注册成为一个beanDefinition从而可以被创建成一个bean
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(MyBeanClassWithoutComponent.class);
        registry.registerBeanDefinition("withoutComponent", genericBeanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

}
