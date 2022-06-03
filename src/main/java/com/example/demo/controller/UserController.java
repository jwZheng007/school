package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody String json, HttpSession session){
        JSONObject jsonobject = JSONObject.parseObject(json);
        String id = jsonobject.get("id").toString();
        String password = jsonobject.get("password").toString();
        User user1 = userMapper.login(Integer.parseInt(id));
        session.setAttribute("id", id);
        if((Integer.parseInt(id) == (user1.getId())) && (password.equals(user1.getPassword()))){
            if(user1.getType().equals("manager")){
                return "Manager.html";
            }else if(user1.getType().equals("teacher")){
                return "Teacher.html";
            }else{
                return "Student.html";
            }
        } else{
        return "error.html";
        }
    }
}
