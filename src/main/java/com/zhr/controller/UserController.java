package com.zhr.controller;

import com.zhr.pojo.RentRelation;
import com.zhr.pojo.User;
import com.zhr.service.UserService;
import com.zhr.utils.Redis;

import com.zhr.utils.response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    Map<String,String> tokenMap = new HashMap<>();
    @Autowired
    private UserService userService;
    Redis redis = new Redis();
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
        String message = "";
        if (userService.login(username, password)) {
            return new response().easyReturn("登录失败");
        } else {
            String token = redis.setUsername(username,password);
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
        String username = redis.getUsername(token);
        response response = new response(status, message, null);
        if (username.equals("")) {
            return new response().easyReturn("错误");
        }
        else {
            User user = userService.findUser(username);
            Map<String, User> map = new HashMap<>();
            user.setPassword("");
            map.put("User",user);
            response.setDetail(map);
        }
        return response;
    }
    @RequestMapping("/recharge")
    public response recharge(String token ,Integer money) {
        String username = redis.getUsername(token);
        if (username.equals("")) {
            return new response().easyReturn("错误");
        }else
            userService.recharge(username,money);
        return new response().easyReturn("充值成功");
    }
    @RequestMapping("/rent/car")
    public response RentCar(String token,Integer carId) {
        String username = redis.getUsername(token);
        if (username.equals("")) {
            return new response().easyReturn("错误");
        }
        User user = userService.findUser(username);
        String message = userService.rentCar(user, carId);
        return new response().easyReturn(message);
    }
    @RequestMapping("/return/car")
    public response ReturnCar(String token ,Integer carId) {
        String username = redis.getUsername(token);
        if( username.equals("")) {
            return new response().easyReturn("token错误");
        }
        User user = userService.findUser(username);
        String message = userService.returnCar(user, carId);
        return new response().easyReturn(message);
    }

    @RequestMapping("/get/rent/car")
    public response getRentCar(String Token) {
        String username = redis.getUsername(Token);
        if (username.equals(""))
            return new response().easyReturn("token错误");
        List<RentRelation> rentCar = userService.getRentCar(username);
        Map<String ,List<RentRelation>> rent = new HashMap<>();
        rent.put("List",rentCar);
        return new response("200", "成功", rent);
    }
}
