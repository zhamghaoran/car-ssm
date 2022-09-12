package com.zhr.utils;

import jdk.javadoc.internal.doclets.toolkit.MemberWriter;

import java.util.Map;

public class response {
    public String status;
    public String message;
    public Map<String , ?> detail;

    public response() {
    }

    public response error(String message) {
        response response = new response();
        response.detail = null;
        response.message = message;
        response.status = "200";
        return response;
    }
    @Override
    public String toString() {
        return "response{" +
                "status='" + status + '\'' +
                ", reason='" + message + '\'' +
                ", map=" + detail +
                '}';
    }

    public response(String status, String reason, Map<String, ?> map) {
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

    public Map<String, ?> getDetail() {
        return detail;
    }

    public void setDetail(Map<String, String> detail) {
        this.detail = detail;
    }
}
