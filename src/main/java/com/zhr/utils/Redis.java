package com.zhr.utils;

import redis.clients.jedis.Jedis;


public class Redis {
    static Jedis jedis;
    static {
        jedis = new Jedis("localhost", 6379);
    }
    public String getUsername(String token) {
        String username = jedis.get(token);
        if (username.equals("")) {
            return "";
        }
        else return username;
    }
    public String setUsername(String username,String password) {
        String token = new getToken(username, password).Token();
        jedis.set(token,username);
        jedis.expire(token,10 * 60); // 设置10分钟的时间
        return token;
    }
}
