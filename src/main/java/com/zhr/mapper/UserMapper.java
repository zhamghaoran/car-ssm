package com.zhr.mapper;

import com.zhr.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    User login(@Param("username") String username,@Param("password") String password);

    User checkUser(@Param("username") String username, @Param("username") String password);

    Integer register(@Param("username") String username,@Param("password") String password);

}
