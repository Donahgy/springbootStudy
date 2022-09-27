package com.example.demo.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.List;

@Data
@TableName(value = "t_student_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDO {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "studentName")
    private String studentName;

    @TableField(value = "age")
    private Integer age;

    @TableField(value = "address")
    private String address;

    @TableField(value = "gender")
    private Integer gender;

    @TableField(exist = false)
    private List<CourseDO> courseDOList;

    @TableField(exist = false)
    private List<ParentDO> parentDOList;
}
