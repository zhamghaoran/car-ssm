package com.zhr.controller;

import com.zhr.mapper.UserMapper;
import com.zhr.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/register")
    public void register(String username,String password) {
        User user = userMapper.checkUser(username, password);
        if (user == null) {
            System.out.println(userMapper.register(username, password));
        }else
            System.out.println("已注册");
    }
}
