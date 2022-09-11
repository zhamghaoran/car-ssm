package com.zhr.utils;

import java.util.Map;
import java.util.Objects;

public class response {
    public String status;
    public String message;
    public Map<String , String> detail;

    @Override
    public String toString() {
        return "response{" +
                "status='" + status + '\'' +
                ", reason='" + message + '\'' +
                ", map=" + detail +
                '}';
    }

    public response(String status, String reason, Map<String, String> map) {
        this.status = status;
        this.message = reason;
        this.detail = map;
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

    public Map<String, String> getDetail() {
        return detail;
    }

    public void setDetail(Map<String, String> detail) {
        this.detail = detail;
    }
}
