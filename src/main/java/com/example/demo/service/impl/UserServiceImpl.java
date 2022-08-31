package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.UserDO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;


public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements IUserService
{
}
