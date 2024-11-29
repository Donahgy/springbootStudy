package com.example.demo.mybatis.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mybatis.dao.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class MybatisController
{

    @Resource
    UserMapper userMapper;

    @RequestMapping(value = "/selectUser")
    public String selectUser()
    {
        return JSONObject.toJSONString(userMapper.selectUser());
    }

}
