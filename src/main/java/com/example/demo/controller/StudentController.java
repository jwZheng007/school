package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.pojo.Os;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentMapper studentMapper;
//    选择课题
    @RequestMapping("/chooseOs")
    @ResponseBody
    public String chooseOs(){
        return "chooseOs.html";
    }
    @RequestMapping("/chooseOs2")
    @ResponseBody
    public String chooseOs2(@RequestBody String json, HttpSession session){
        JSONObject jsonobject = JSONObject.parseObject(json);
        String os_id = jsonobject.get("os_id").toString();
        int os = Integer.parseInt(os_id);
        int id = Integer.parseInt((String) session.getAttribute("id"));
        studentMapper.chooseOs(os, id);
        return "1";
    }

    //    查看课题
    @RequestMapping("/checkOs")
    @ResponseBody
    public String checkOs(){
        return "checkOs.html";
    }
    @RequestMapping("/checkOs2")
    @ResponseBody
    public String checkOs2( HttpSession session){
        int id = Integer.parseInt((String)session.getAttribute("id"));
        String os_name = studentMapper.checkOs(id);
        return os_name;
    }

//    提交毕业论文
    @RequestMapping("/submitTheis")
    @ResponseBody
    private String submitTheis(){
        return "submitTheis.html";
    }
    @RequestMapping("/submitTheis2")
    @ResponseBody
    public String submitTheis2(@RequestBody String json, HttpSession session){
        JSONObject jsonobject = JSONObject.parseObject(json);
        String theis = jsonobject.get("theis").toString();
        int id = Integer.parseInt((String)session.getAttribute("id"));
        studentMapper.submitTheis(theis,id);
        return "1";
    }

    //    提交开题报告
    @RequestMapping("/submitOs")
    @ResponseBody
    private String submitOs(){
        return "submitOs.html";
    }
    @RequestMapping("/submitOs2")
    @ResponseBody
    public String submitOs2(@RequestBody String json, HttpSession session){
        JSONObject jsonobject = JSONObject.parseObject(json);
        String stu_os = jsonobject.get("stu_os").toString();
        int id = Integer.parseInt((String)session.getAttribute("id"));
        studentMapper.submitOs(stu_os, id);
        return "1";
    }
    @RequestMapping("/viewOs_id")
    @ResponseBody
    public List<Os> viewOs_id(){
        return studentMapper.viewOs_id();
    }
}
