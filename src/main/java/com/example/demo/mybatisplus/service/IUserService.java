package com.example.demo.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.mybatisplus.entity.UserDO;

import java.util.List;


public interface IUserService extends IService<UserDO>
{

    List<UserDO> selectAll();
}
