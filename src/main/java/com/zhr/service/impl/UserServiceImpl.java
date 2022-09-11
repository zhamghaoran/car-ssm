package com.zhr.service.impl;

import com.zhr.mapper.UserMapper;
import com.zhr.pojo.User;
import com.zhr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public boolean login(String username, String password) {
        User user = userMapper.login(username, password);
        return user != null;
    }
}
