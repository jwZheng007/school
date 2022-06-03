package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.TeacherMapper;
import com.example.demo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    TeacherMapper teacherMapper;

    //选择学生
    @RequestMapping("/addStudent")
    @ResponseBody
    public String addStudent(){
        return "addStudent.html";
    }
    @RequestMapping("/viewStudents")
    @ResponseBody
    public List<Student> viewStudents() {
        return teacherMapper.viewStudents();
    }

    @RequestMapping("/addStudent2")
    @ResponseBody
    public String addStudent2(@RequestBody String json, HttpSession session){
        JSONObject jsonobject = JSONObject.parseObject(json);
        String stu_id = jsonobject.get("stu_id").toString();
        int id = Integer.parseInt((String)session.getAttribute("id"));
        teacherMapper.addStudent(Integer.parseInt(stu_id), id);
        return "1";
    }
    @RequestMapping("/setOs")
    @ResponseBody
    public String setOs(){
        return "setOs.html";
    }
    @RequestMapping("setOs2")
    @ResponseBody
    public String setOs2(@RequestBody String json){
        JSONObject jsonobject = JSONObject.parseObject(json);
        String os = jsonobject.get("os").toString();
        int sum = teacherMapper.checkOs();
        teacherMapper.setOs(sum+1, os);
        return "1";
    }
    @RequestMapping("check2Os")
    @ResponseBody
    public String check2Os(){
        return "check2Os.html";
    }
    @RequestMapping("checkTheis")
    @ResponseBody
    public String checkTheis(){
        return "checkTheis.html";
    }
    @RequestMapping("/viewMyStudents")
    @ResponseBody
    public List<Student> viewMyStudents(HttpSession session){
       return teacherMapper.viewMyStudents(Integer.parseInt((String)session.getAttribute("id")));
    }
    @RequestMapping("/viewOs")
    @ResponseBody
    public String viewOs(@RequestBody String json){
        JSONObject jsonobject = JSONObject.parseObject(json);
        String stu_id = jsonobject.get("stu_id").toString();
        System.out.println(teacherMapper.viewOs(Integer.parseInt(stu_id)));
        return teacherMapper.viewOs(Integer.parseInt(stu_id));
    }

    @RequestMapping("/viewTheis")
    @ResponseBody
    public String viewTheis(@RequestBody String json){
        JSONObject jsonobject = JSONObject.parseObject(json);
        String stu_id = jsonobject.get("stu_id").toString();
        return teacherMapper.viewTheis(Integer.parseInt(stu_id));
    }

    @RequestMapping("/grade")
    @ResponseBody
    public String grade(@RequestBody String json){
        JSONObject jsonobject = JSONObject.parseObject(json);
        String grade = jsonobject.get("grade").toString();
        String stu_id = jsonobject.get("stu_id").toString();
        teacherMapper.grade(Integer.parseInt(stu_id), Integer.parseInt(grade));
        return "1";
    }
    @RequestMapping("checkStudent")
    @ResponseBody
    public String checkStudent(){
        return "checkStudent.html";
    }
}
