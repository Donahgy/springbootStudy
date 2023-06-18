package com.example.demo.myevent.testevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyselfListener implements ApplicationListener<MyselfEvent> {

    @Override
    public void onApplicationEvent(MyselfEvent event) {
        System.out.println("事件被监听到执行该方法...");
    }
}
