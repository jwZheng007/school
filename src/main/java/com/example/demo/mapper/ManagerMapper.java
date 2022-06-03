package com.example.demo.mapper;

import com.example.demo.pojo.Student;
import com.example.demo.pojo.Teacher;
import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
@Repository
public interface ManagerMapper {
//    添加学生
    public void addStudentToTeacher(@RequestParam("stu_id") int stu_id,@RequestParam("tea_id") int tea_id);
//    删除学生
    public void deleteStudentFromTeacher(@RequestParam("stu_id") int stu_id,@RequestParam("tea_id") int tea_id);
//    注册教师
    public void registerTeacher(Teacher teacher);
//    注册学生
    public void registerStudent(Student student);

    public void register(User user);
}
