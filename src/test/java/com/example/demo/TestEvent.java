package com.example.demo;

import com.example.demo.myevent.environmentevent.YmlUtil;
import com.example.demo.myevent.testevent.MyEventService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ResolvableType;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


@SpringBootTest
public class TestEvent {

    private HashMap<Integer, List<String>> myMap;

    @Resource
    MyEventService myEventService;

    @org.junit.jupiter.api.Test
    public void test()
    {
        myEventService.myMethod();
        System.out.println(YmlUtil.getSystemEnvironment());
        System.out.println("---------------------------------------------------");
        System.out.println(YmlUtil.getSystemEnvironment());
        System.out.println("---------------------------------------------------");
        System.out.println(YmlUtil.getString("spring.redis.redisson.file"));
    }

    public static void main(String[] args)
        throws NoSuchFieldException
    {
        ResolvableType t = ResolvableType.forField(TestEvent.class.getDeclaredField("myMap"));
        t.getSuperType();
        t.asMap();
        t.getGeneric(0).resolve();
        t.getGeneric(1).resolve();
        t.getGeneric(1);
        t.resolveGeneric(1,0);
        A<String> stringA = new A<>();
        ResolvableType generic = ResolvableType.forClassWithGenerics(stringA.getClass(),TestEvent.class).getGeneric();
        System.out.println(generic);
    }
}

class A<T> {

}
