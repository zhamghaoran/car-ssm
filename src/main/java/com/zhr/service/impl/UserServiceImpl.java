package com.zhr.service.impl;

import com.zhr.mapper.CarMapper;
import com.zhr.mapper.UserMapper;
import com.zhr.mapper.rentRelationMapper;
import com.zhr.pojo.Car;
import com.zhr.pojo.RentRelation;
import com.zhr.pojo.User;
import com.zhr.service.UserService;
import com.zhr.utils.common.util.SecureUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private rentRelationMapper rentRelationMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CarMapper carMapper;

    @Override
    public boolean login(String username, String password) {
        User user = userMapper.login(username, SecureUtils.getMD5(password));
        return user == null;
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
        if (car.isRentOrNot()) {
            return "该车辆已出租";
        }
        Date date = new Date(System.currentTimeMillis());
        userMapper.rent(user.getUsername(),carId);
        carMapper.rentCar(carId,date);
        rentRelationMapper.Insert(user.getUsername(),"Car",carId);
        return "租借成功";
    }

    @Override
    public String returnCar(User user, Integer carId) {
        Car car = carMapper.getCar(carId);
        if (!car.isRentOrNot()) {
            return "car_Id错误";
        }
        Date date = new Date(System.currentTimeMillis());
        Date rentTime = car.RentTimeDate();
        long l = date.getTime() - rentTime.getTime();
        long nd = 1000 * 24 * 60 * 60;
        long day =  l / nd;
        if (user.getMoney() < (day) * car.getPrice()) {
            return "余额不足";
        }
        carMapper.returnCar(carId);
        userMapper.ReturnCar(user.getUsername(),Math.max(0,day) * car.getPrice());
        rentRelationMapper.Delete(user.getUsername(),"Car",carId);
        return "还车成功";
    }

    @Override
    public List<RentRelation> getRentCar(String username) {
        return rentRelationMapper.selectRentListByUsername(username);
    }
}
