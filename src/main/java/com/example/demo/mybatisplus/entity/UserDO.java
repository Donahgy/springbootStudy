package com.example.demo.mybatisplus.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.*;
import com.example.demo.mybatisplus.myenum.EducationBackgroundEnum;
import com.example.demo.mybatisplus.myenum.SexEnum;

import java.time.LocalDateTime;


@TableName(value = "user")
public class UserDO
{

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "nickname",condition = SqlCondition.EQUAL)
    private String nickname;


    @TableField(value = "sex")
    @JSONField(serialzeFeatures = SerializerFeature.WriteEnumUsingToString)
    private SexEnum sex;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @JSONField(serialzeFeatures = SerializerFeature.WriteEnumUsingToString)
    @TableField(value = "education_background")
    private EducationBackgroundEnum educationBackgroundEnum;

    @TableField(value = "dept",fill = FieldFill.INSERT_UPDATE)
    private String dept;

    /**
     * 逻辑删除字段
     */
    @TableLogic
    @TableField(value = "is_delete")
    private Integer isDelete;

    public UserDO() {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public EducationBackgroundEnum getEducationBackgroundEnum()
    {
        return educationBackgroundEnum;
    }

    public void setEducationBackgroundEnum(EducationBackgroundEnum educationBackgroundEnum)
    {
        this.educationBackgroundEnum = educationBackgroundEnum;
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


    public LocalDateTime getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime)
    {
        this.createTime = createTime;
    }

    public String getDept()
    {
        return dept;
    }

    public void setDept(String dept)
    {
        this.dept = dept;
    }

    public Integer getIsDelete()
    {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete)
    {
        this.isDelete = isDelete;
    }

    @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", nickname='" + nickname + '\'' + ", sex=" + sex
               + ", createTime=" + createTime + ", educationBackgroundEnum="
               + educationBackgroundEnum + ", dept='" + dept + '\'' + '}';
    }
}
