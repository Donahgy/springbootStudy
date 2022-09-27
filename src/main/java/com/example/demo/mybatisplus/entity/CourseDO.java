package com.example.demo.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "t_student_course")
@AllArgsConstructor
@NoArgsConstructor
public class CourseDO {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "courseName")
    private String courseName;

    @TableField(value = "courseTeacher")
    private String courseTeacher;

    @TableField(value = "studentId")
    private Integer studentId;
}
