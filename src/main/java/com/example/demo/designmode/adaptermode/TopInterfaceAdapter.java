package com.example.demo.designmode.adaptermode;

import org.springframework.core.ResolvableType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TopInterfaceAdapter implements TopInterface {

    ArrayList<Object> values;

    private String name;

    private String word;

    public TopInterfaceAdapter(Object clazz) throws InvocationTargetException, IllegalAccessException {
        values = new ArrayList<>();
        ResolvableType declaredEventType = ResolvableType.forType(clazz.getClass());
        System.out.println(declaredEventType);
        Class<?> resolve = declaredEventType.as(People.class).resolve();
        Method[] methods = resolve.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get"))
            {
                values.add(method.invoke(clazz));
            }
        }
        this.name = (String) values.get(0);
        this.word = (String) values.get(1);
    }

    @Override
    public void say(String name, String word) {
        System.out.println("他是" + name + ",他说" + word);
        System.out.println("这是顶层接口转换的适配器");
    }
}
