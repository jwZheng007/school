package com.example.demo.mapper;

import com.example.demo.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {
    //    添加学生
    public void addStudent(@RequestParam("stu_id") int stu_id, @RequestParam("tea_id") int tea_id);
//    出题
    public void setOs(@RequestParam("id") int id, @RequestParam("os") String os);
// 查询题目个数
    public Integer checkOs();
//    查看students
    public List<Student> viewStudents();
//    查看我的students
    public List<Student> viewMyStudents(@RequestParam("tea_id") int tea_id);
//    根据id找到os
    public String viewOs(@RequestParam("stu_id") int stu_id);
    //    根据id找到theis
    public String viewTheis(@RequestParam("stu_id") int stu_id);
//    theis得分
    public void grade(@RequestParam("stu_id") int stu_id,@RequestParam("theis_grade") int theis_grade);
}
