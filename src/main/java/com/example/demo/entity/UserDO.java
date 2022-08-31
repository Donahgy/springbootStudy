package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.example.demo.myenum.SexEnum;

import java.time.LocalDateTime;


@TableName(value = "user")
public class UserDO
{

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "nickname",condition = SqlCondition.EQUAL)
    private String nickname;

    @TableField(value = "sex")
    private SexEnum sex;

    @TableField(value = "version",update = "%s+1")
    private Integer version;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public SexEnum getSex()
    {
        return sex;
    }

    public void setSex(SexEnum sex)
    {
        this.sex = sex;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    public LocalDateTime getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime)
    {
        this.createTime = createTime;
    }

    @Override
    public String toString()
    {
        return "UserDO{" + "id=" + id + ", nickname='" + nickname + '\'' + ", sex=" + sex
               + ", version=" + version + ", createTime=" + createTime + '}';
    }
}
