package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.UserDO;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


public interface IUserService extends IService<UserDO>
{

    List<UserDO> selectAll();
}
