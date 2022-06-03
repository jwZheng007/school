package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int stu_id;
    private String stu_name;
    private String os_id;
    private String tea_id;
    private String theis;
    private String stu_os;
    private int theis_grade;
}
