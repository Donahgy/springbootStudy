package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.StudentDO;

import java.util.List;

public interface StudentService extends IService<StudentDO> {
    List<StudentDO> studentList();
}
