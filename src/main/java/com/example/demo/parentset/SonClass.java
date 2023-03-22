package com.example.demo.parentset;

import org.springframework.stereotype.Component;


@Component
public class SonClass extends AbstractParent
{

    public void sonCommonMethod()
    {
        System.out.println("执行子类的普通方法");
    }
}
