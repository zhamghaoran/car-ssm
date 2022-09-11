package com.zhr.controller;

import com.zhr.pojo.User;
import com.zhr.service.UserService;
import com.zhr.utils.getToken;
import com.zhr.utils.response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
    Map<String,String> tokenMap = new HashMap<>();
    @Autowired
    private UserService userService;
    @RequestMapping("/register")
    public response register(String username,String password) {
        response response;
        if (userService.checkUser(username, password)) {
            userService.register(username,password);
            response = new response("200", "注册成功", null);
        }else {
            response = new response("200","已注册" , null);
        }
        return response;
    }
    @RequestMapping("/login")
    public response login(String username,String password) {
        String status = "200";
        String message;
        if (userService.login(username, password)) {
            message = "登录失败";
            return new response(status,message,null);
        } else {
            String token = new getToken(username, password).Token();
            Map<String ,String > map = new HashMap<>();
            message = "登录成功";
            map.put("token",token);
            tokenMap.put(token,username);
            return new response(status,message,map);
        }
    }
    @RequestMapping("/personal/center")
    public response personalCenter(String token) {
        String status = "200";
        String message = "";
        String username = tokenMap.get(token);
        response response = new response(status, message, null);
        if (username == null) {
            message = "错误";
        }
        else {
            User user = userService.findUser(username);
            message = "";
            Map<String, String> map = new HashMap<>();
            map.put("Username",user.getUsername());
            map.put("CarRent", String.valueOf(user.getCarRent()));
            map.put("Money", String.valueOf(user.getMoney()));
            map.put("TruckRent", String.valueOf(user.getTruckRent()));
            response.setDetail(map);
        }
        return response;
    }
}
