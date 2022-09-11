package com.zhr.service.impl;

import com.zhr.mapper.UserMapper;
import com.zhr.pojo.User;
import com.zhr.service.UserService;
import com.zhr.utils.common.util.SecureUtils;
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

    @Override
    public boolean checkUser(String username, String password) {

        User user = userMapper.checkUser(username, password);
        return user != null;
    }

    @Override
    public void register(String username, String password) {
        String passwordMd5 = SecureUtils.getMD5(password);
        userMapper.register(username, passwordMd5);
    }
}
