package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.UserDO;
import com.example.demo.myenum.EducationBackgroundEnum;
import com.example.demo.myenum.SexEnum;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/user")
public class UserController {

    static Integer[] array = {1,2,3,4,5,6};

    static Integer[] sexArray = {1,2};

    @Autowired
    private IUserService userService;

    @RequestMapping("/save")
    public boolean save() {
        UserDO userDO = new UserDO();
        userDO.setNickname("潘东");
        int i = sexArray[new Random().nextInt(sexArray.length)];
        if (i == 1)
        {
            userDO.setSex(SexEnum.MAN);
        }
        if (i == 2)
        {
            userDO.setSex(SexEnum.WOMAN);
        }
        i = array[new Random().nextInt(array.length)];
        if (i == 1)
        {
            userDO.setEducationBackgroundEnum(EducationBackgroundEnum.PRIMARY_SCHOOL);
        }
        if (i == 2)
        {
            userDO.setEducationBackgroundEnum(EducationBackgroundEnum.JUNIOR_HIGH_SCHOOL);
        }
        if (i == 3)
        {
            userDO.setEducationBackgroundEnum(EducationBackgroundEnum.SENIOR_HIGH_SCHOOL);
        }
        if (i == 4)
        {
            userDO.setEducationBackgroundEnum(EducationBackgroundEnum.UNIVERSITY);
        }
        if (i == 5)
        {
            userDO.setEducationBackgroundEnum(EducationBackgroundEnum.MASTER_DEGREE);
        }
        if (i == 6)
        {
            userDO.setEducationBackgroundEnum(EducationBackgroundEnum.DOCTOR);
        }
        return userService.save(userDO);
    }

    @RequestMapping("/update")
    public boolean update(@RequestParam String nickname, @RequestParam Long id) {
        UserDO userDO = new UserDO();
        userDO.setNickname(nickname);
        userDO.setId(id);
        return userService.updateById(userDO);
    }

    @RequestMapping(value = "/delete")
    public boolean delete(@RequestParam Long id) {
        UserDO userDO = new UserDO();
        userDO.setId(id);
        return userService.removeById(userDO);
    }

    @RequestMapping(value = "/list")
    public List<UserDO> list() {
//        return userService.list().stream().map(li -> {
//            Map<String,Object> userMap = new HashMap<>();
//            userMap.put("id",li.getId());
//            userMap.put("nickname",li.getNickname());
//            userMap.put("sex",li.getSex().getName());
//            userMap.put("createTime",li.getCreateTime());
//            return userMap;
//        }).collect(Collectors.toList());
        return userService.list();
    }

    @RequestMapping(value = "/page")
    public Page page(@RequestParam int current, @RequestParam int size) {
        return userService.page(new Page<>(current, size), new QueryWrapper<>(new UserDO()));
    }

    @RequestMapping(value = "/logicDelete")
    public boolean logicDelete(@RequestParam Long id)
    {
        return userService.removeById(id);
    }

    @RequestMapping(value = "/selectAll")
    public Object selectAll()
    {
        return userService.selectAll();
    }
}
