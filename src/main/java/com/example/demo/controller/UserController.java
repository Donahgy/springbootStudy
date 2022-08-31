package com.example.demo.controller;

import com.example.demo.entity.UserDO;
import com.example.demo.myenum.SexEnum;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController
{

    @Autowired
    private IUserService userService;

    @RequestMapping("/save")
    public boolean save()
    {
        UserDO userDO = new UserDO();
        userDO.setNickname("潘东");
        userDO.setSex(SexEnum.WOMAN);
        return userService.save(userDO);
    }

    @RequestMapping("/update")
    public boolean update(@RequestParam String nickname,@RequestParam Long id)
    {
        UserDO userDO = new UserDO();
        userDO.setNickname(nickname);
        userDO.setId(id);
        return userService.updateById(userDO);
    }


}
