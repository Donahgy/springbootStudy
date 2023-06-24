package com.example.demo.designmode.adaptermode;

import java.lang.reflect.InvocationTargetException;

public class TestClass {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        People people = new People("潘东", "你好啊，我叫潘东");
        TopInterfaceAdapter adapter = new TopInterfaceAdapter(people);
    }
}
