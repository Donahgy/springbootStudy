package com.example.demo.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
@Mapper
public interface UserMapper
{

    List<Map<String,Object>> selectUser();

}
