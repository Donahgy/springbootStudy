package com.example.demo.parentset;

public abstract class AbstractParent implements TopInterface
{

    public AbstractParent()
    {
        System.out.println("执行父类的构造方法...");
        init();
    }

    public void init()
    {
        sonCommonMethod();
        System.out.println("执行父类的普通方法...");
    }
}
