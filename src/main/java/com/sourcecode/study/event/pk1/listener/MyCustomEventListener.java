package com.sourcecode.study.event.pk1.listener;

import com.sourcecode.study.event.pk1.event.MyCustomEvent;
import org.springframework.context.ApplicationListener;


public class MyCustomEventListener implements ApplicationListener<MyCustomEvent>
{

    @Override
    public void onApplicationEvent(MyCustomEvent event)
    {
        System.out.println("自定义事件...");
    }
}
