package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.ManagerMapper;
import com.example.demo.pojo.StudentAndUser;
import com.example.demo.pojo.TeacherAndUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ManagerController {
    @Autowired
    private ManagerMapper managerMapper;
//添加学生到教师
    @RequestMapping("/addStudentToTeacher")
    public String addStudentToTeacher(){
        return "addStudentToTeacher";
    }

    @ResponseBody
    @RequestMapping("/addStudentToTeacher2")
    public String addStudentToTeacher2(@RequestBody String json){
        JSONObject jsonobject = JSONObject.parseObject(json);
        String stu_id = jsonobject.get("stu_id").toString();
        String tea_id = jsonobject.get("tea_id").toString();
        managerMapper.addStudentToTeacher(Integer.parseInt(stu_id),Integer.parseInt(tea_id));
        return "1";
    }
// 从教师删除学生
    @RequestMapping("/deleteStudentFromTeacher")
    public String deleteStudentFromTeacher(){
        return "deleteStudentFromTeacher";
    }

    @ResponseBody
    @RequestMapping("/deleteStudentFromTeacher2")
    public String deleteStudentFromTeacher2(@RequestBody String json){
        JSONObject jsonobject = JSONObject.parseObject(json);
        String stu_id = jsonobject.get("stu_id").toString();
        String tea_id = jsonobject.get("tea_id").toString();
        managerMapper.deleteStudentFromTeacher(Integer.parseInt(stu_id), Integer.parseInt(tea_id));
        return "1";
    }
//    注册教师
    @RequestMapping("/registerTeacher")
    public String registerTeacher(){
        return "registerTeacher";
    }

    @RequestMapping("/registerTeacher2")
    @ResponseBody
    public String registerTeacher2(@RequestBody TeacherAndUser teacheranduser){
        managerMapper.register(teacheranduser.getUser());
        managerMapper.registerTeacher(teacheranduser.getTeacher());
        return "1";
    }
//注册学生
    @RequestMapping("/registerStudent")
    public String registerStudent(){
        return "registerStudent";
    }

    @RequestMapping("/registerStudent2")
    @ResponseBody
    public String registerStudent2(@RequestBody StudentAndUser studentanduser){
        managerMapper.register(studentanduser.getUser());
        managerMapper.registerStudent(studentanduser.getStudent());
        return "1";
    }
}
