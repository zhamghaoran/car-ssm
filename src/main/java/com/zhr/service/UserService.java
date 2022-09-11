package com.zhr.service;

import com.zhr.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    boolean login(String username, String password);
}
