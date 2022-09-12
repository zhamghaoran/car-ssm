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
public class UserController {
    Map<String,String> tokenMap = new HashMap<>();
    @Autowired
    private UserService userService;
    @RequestMapping("/register")
    public response register(String username,String password) {

        if (userService.checkUser(username, password)) {
            userService.register(username,password);
            return new response().easyReturn("已注册");
        }else {
            return new response().easyReturn("注册成功");
        }
    }
    @RequestMapping("/login")
    public response login(String username,String password) {
        String status = "200";
        String message;
        if (userService.login(username, password)) {
            return new response().easyReturn("登录失败");
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
            return new response().easyReturn("错误");
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
    @RequestMapping("/recharge")
    public response recharge(String token ,Integer money) {
        String status = "20";
        String message = "";
        String username = tokenMap.get(token);
        if (username == null) {
            return new response().easyReturn("错误");
        }else
            userService.recharge(username,money);
        return new response().easyReturn("充值成功");
    }
    @RequestMapping("/rent/car")
    public response RentCar(String token,Integer carId) {
        String username = tokenMap.get(token);
        if (username == null) {
            return new response().easyReturn("错误");
        }
        User user = userService.findUser(username);
        String s = userService.rentCar(user, carId);
        return new response().easyReturn(s);
    }

}
