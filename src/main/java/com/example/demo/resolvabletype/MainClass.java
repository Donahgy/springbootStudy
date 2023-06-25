package com.example.demo.resolvabletype;

import org.springframework.context.event.GenericApplicationListenerAdapter;
import org.springframework.core.ResolvableType;

import java.lang.reflect.Field;

/**
 * 获取当前类的信息并将其封装成ResolvableType对象，其中的resolved和type就是当前传进去的类型。
 * as方法是将第一步产生的ResolvableType对象进一步处理成对应的as方法中的接口类型信息，从而进一步
 * 获取到接口的泛型信息。
 * spring在 {@link GenericApplicationListenerAdapter#resolveDeclaredEventType(Class)}
 * 中获取监听器对应的事件类型就是通过这种方式实现的
 */
public class MainClass {
    public static void main(String[] args) {
        ResolvableType generic = ResolvableType.forClass(TopInterfaceImpl.class).as(TopInterface.class).getGeneric();
        System.out.println(generic);
        Class<?> aClass = ResolvableType.forInstance(new People("Jack", 12)).getRawClass();
        for (Field field : aClass.getDeclaredFields()) {
            System.out.println(field);
        }
    }
}
