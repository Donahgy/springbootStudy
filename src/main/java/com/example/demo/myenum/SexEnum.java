package com.example.demo.myenum;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SexEnum implements IEnum<Integer>
{
    MAN(1,"男"),
    WOMAN(2,"女");

    private Integer code;
    private String name;

    SexEnum(Integer code, String name)
    {
        this.code = code;
        this.name = name;
    }

    @Override
    public Integer getValue()
    {
        return code;
    }

    public String getName()
    {
        return name;
    }
}
