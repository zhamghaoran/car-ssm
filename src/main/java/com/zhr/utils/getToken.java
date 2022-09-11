package com.zhr.utils;

import com.zhr.utils.common.util.SecureUtils;

import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class getToken {
    private String username;
    private String password;

    public getToken(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String Token() {
        return SecureUtils.getMD5(username + password + new Date());
    }
}
