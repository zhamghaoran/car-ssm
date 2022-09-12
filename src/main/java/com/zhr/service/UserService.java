package com.zhr.service;

import com.zhr.pojo.User;

public interface UserService {
    boolean login(String username, String password);

    boolean checkUser(String username, String password);

    void register(String username,String password);

    User findUser(String username);

    Integer recharge(String username,Integer number);

    String rentCar(User user,Integer carId);
}
