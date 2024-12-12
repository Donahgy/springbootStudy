package com.example.demo.event.customevent.listener;

import com.example.demo.event.customevent.event.CustomEvent;
import com.example.demo.event.customevent.event.Source;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class CustomListener implements ApplicationListener<CustomEvent>
{


    @Override
    public void onApplicationEvent(CustomEvent event)
    {
        Source source = (Source)event.getSource();
        try
        {
            Thread.sleep(60000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        System.out.println(source.getNum());
    }
}
