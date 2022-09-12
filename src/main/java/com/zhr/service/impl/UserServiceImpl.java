package com.zhr.service.impl;

import com.zhr.mapper.CarMapper;
import com.zhr.mapper.UserMapper;
import com.zhr.pojo.Car;
import com.zhr.pojo.User;
import com.zhr.service.CarService;
import com.zhr.service.UserService;
import com.zhr.utils.common.util.SecureUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CarMapper carMapper;

    @Override
    public boolean login(String username, String password) {
        User user = userMapper.login(username, password);
        return user != null;
    }

    @Override
    public boolean checkUser(String username, String password) {

        User user = userMapper.checkUser(username, password);
        return user == null;
    }

    @Override
    public void register(String username, String password) {
        String passwordMd5 = SecureUtils.getMD5(password);
        userMapper.register(username, passwordMd5);
    }

    @Override
    public User findUser(String username) {
        return userMapper.checkUser(username,null);
    }

    @Override
    public Integer recharge(String username, Integer number) {
        return userMapper.charge(username, number);
    }

    @Override
    public String rentCar(User user, Integer carId) {
        Car car = carMapper.getCar(carId);
        if (car == null) {
            return "car_id错误";
        }
        if (user.getMoney() < car.getPrice()) {
            return "余额不足";
        }
        userMapper.rent(user.getUsername(),carId,user.getMoney());
        return "租借成功";
    }
}
