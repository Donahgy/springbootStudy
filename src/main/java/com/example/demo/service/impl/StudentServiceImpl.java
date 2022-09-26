package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.StudentDO;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl  extends ServiceImpl<StudentMapper, StudentDO> implements StudentService {

    @Resource
    StudentMapper studentMapper;

    @Override
    public List<StudentDO> studentList() {
        return studentMapper.selectAllData();
    }
}
