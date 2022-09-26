package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.StudentDO;

import java.util.List;

public interface StudentMapper extends BaseMapper<StudentDO> {

    List<StudentDO> selectAllData();
}
