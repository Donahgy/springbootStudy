package com.example.demo.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.mybatisplus.entity.StudentDO;

import java.util.List;

public interface StudentService extends IService<StudentDO> {
    List<StudentDO> studentList();
}
