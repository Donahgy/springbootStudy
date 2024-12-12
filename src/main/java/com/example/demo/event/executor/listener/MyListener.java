package com.example.demo.event.executor.listener;

import com.example.demo.event.executor.event.MyCustomEvent;
import com.example.demo.event.executor.source.MySourceObject;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class MyListener implements ApplicationListener<MyCustomEvent>
{
    @Override
    public void onApplicationEvent(MyCustomEvent event)
    {
        MySourceObject source = (MySourceObject)event.getSource();
        try
        {
            Thread.sleep(60000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        System.out.println(source.getName());
    }
}
