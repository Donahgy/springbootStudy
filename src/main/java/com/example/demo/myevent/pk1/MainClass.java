package com.example.demo.myevent.pk1;

import com.example.demo.myevent.pk1.event.impl.ApplicationEventImpl1;
import com.example.demo.myevent.pk1.event.impl.ApplicationEventImpl2;
import com.example.demo.myevent.pk1.listener.ApplicationListener;
import com.example.demo.myevent.pk1.listener.GenericApplicationListener;
import com.example.demo.myevent.pk1.listener.GenericApplicationListenerAdapter;
import com.example.demo.myevent.pk1.listener.impl.MyApplicationListenerImpl1;
import com.example.demo.myevent.pk1.listener.impl.MyApplicationListenerImpl2;
import com.example.demo.myevent.pk1.listener.impl.MyApplicationListenerImpl3;
import org.springframework.core.ResolvableType;


public class MainClass {
    public static void main(String[] args) {
        MyApplicationListenerImpl1 myApplicationListenerImpl1 = new MyApplicationListenerImpl1();
        MyApplicationListenerImpl2 myApplicationListenerImpl2 = new MyApplicationListenerImpl2();
        MyApplicationListenerImpl3 myApplicationListenerImpl3 = new MyApplicationListenerImpl3();
        ResolvableType resolvableType1 = ResolvableType.forInstance(new ApplicationEventImpl1());
        ResolvableType resolvableType2 = ResolvableType.forInstance(new ApplicationEventImpl2());
        boolean flag1 = supportsEvent(myApplicationListenerImpl1, resolvableType1);
        System.out.println(flag1);
        boolean flag2 = supportsEvent(myApplicationListenerImpl2, resolvableType2);
        System.out.println(flag2);
        boolean flag3 = supportsEvent(myApplicationListenerImpl3, resolvableType2);
        System.out.println(flag3);
    }

    protected static boolean supportsEvent(
            ApplicationListener<?> listener, ResolvableType eventType) {

        GenericApplicationListener smartListener = (listener instanceof GenericApplicationListener ?
                (GenericApplicationListener) listener : new GenericApplicationListenerAdapter(listener));
        return (smartListener.supportEventType(eventType));
    }
}
