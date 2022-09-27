package com.example.demo.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.mybatisplus.entity.UserDO;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface UserMapper extends BaseMapper<UserDO>
{

    List<UserDO> selectAll();

}
