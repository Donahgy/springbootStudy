package com.example.demo.mybatisplus.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mybatisplus.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Resource
    StudentService studentServiceImpl;

    @RequestMapping(value = "/studentList")
    public String studentList()
    {
        return JSONObject.toJSONString(studentServiceImpl.studentList());
    }
}
