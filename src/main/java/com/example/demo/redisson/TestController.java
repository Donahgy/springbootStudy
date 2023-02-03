package com.example.demo.redisson;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
public class TestController
{

    @Resource
    TestRedisson testRedisson;

    @RequestMapping(value = "/addUser/{userId}",method = RequestMethod.GET)
    public void addUser(@PathVariable String userId)
    {
        testRedisson.updateUser(userId);
    }

}
