package com.example.demo.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mybatisplus.entity.UserDO;
import com.example.demo.mybatisplus.mapper.UserMapper;
import com.example.demo.mybatisplus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements IUserService
{

    @Autowired
    UserMapper userMapper;

    public List<UserDO> selectAll()
    {
        return userMapper.selectAll();
    }
}
