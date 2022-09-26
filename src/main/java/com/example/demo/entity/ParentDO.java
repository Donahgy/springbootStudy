package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "t_student_parent")
@AllArgsConstructor
@NoArgsConstructor
public class ParentDO {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "parentName")
    private String parentName;

    @TableField(value = "isMonOrDad")
    private Integer isMonOrDad;

    @TableField(value = "parentGender")
    private Integer parentGender;

    @TableField(value = "studentId")
    private Integer studentId;

}
