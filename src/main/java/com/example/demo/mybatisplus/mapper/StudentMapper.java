package com.example.demo.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.mybatisplus.entity.StudentDO;

import java.util.List;

public interface StudentMapper extends BaseMapper<StudentDO> {

    List<StudentDO> selectAllData();
}
