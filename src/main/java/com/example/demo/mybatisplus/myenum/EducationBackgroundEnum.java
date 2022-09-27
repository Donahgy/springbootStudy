package com.example.demo.mybatisplus.myenum;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EducationBackgroundEnum implements IEnum<Integer>
{
    PRIMARY_SCHOOL(1,"小学"),
    JUNIOR_HIGH_SCHOOL(2,"初中"),
    SENIOR_HIGH_SCHOOL(3,"高中"),
    UNIVERSITY(4,"大学"),
    MASTER_DEGREE(5,"硕士研究生"),
    DOCTOR(6,"博士");

    private Integer code;
    private String educationBackground;

    EducationBackgroundEnum()
    {
    }

    EducationBackgroundEnum(Integer code, String educationBackground)
    {
        this.code = code;
        this.educationBackground = educationBackground;
    }

    @Override
    public Integer getValue()
    {
        return code;
    }

    public String getEducationBackground()
    {
        return educationBackground;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public void setEducationBackground(String educationBackground)
    {
        this.educationBackground = educationBackground;
    }
}
