package com.example.demo.redisson;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
public class TestController
{

    @Resource
    TestRedisson testRedisson;

    private static int num = 0;

    @PostConstruct
    public void init()
    {
        System.out.println("PostConstruct修饰的方法被执行了...");
        num = 1;
        System.out.println(num);
        testRedisson.say();
    }


    @RequestMapping(value = "/addUser/{userId}",method = RequestMethod.GET)
    public void addUser(@PathVariable String userId)
    {
        testRedisson.updateUser(userId);
    }

}
