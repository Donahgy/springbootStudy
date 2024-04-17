package com.example.demo;

import com.example.demo.sourcecode.convert.MyConvert;
import com.example.demo.sourcecode.convert.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class MyConvertTest {

    @Autowired
    MyConvert myConvert;

    @Test
    public void test() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jack");
        map.put("age", "22");
        myConvert.canConvert(Map.class, Person.class);
        Person person = myConvert.convert(map, Person.class);
        System.out.println(person);
    }
}
