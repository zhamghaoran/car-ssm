package com.zhr.utils;

import java.util.Map;

public class response {
    public String status;
    public String message;
    public Map<String ,String > map;

    @Override
    public String toString() {
        return "response{" +
                "status='" + status + '\'' +
                ", reason='" + message + '\'' +
                ", map=" + map +
                '}';
    }

    public response(String status, String reason, Map<String, String> map) {
        this.status = status;
        this.message = reason;
        this.map = map;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
