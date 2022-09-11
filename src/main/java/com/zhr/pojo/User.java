package com.zhr.pojo;

public class User {
    private String username;
    private String password;
    private Integer carRent;
    private Integer truckRent;
    private Integer money;

    public User() {
    }

    public User(String username, String password, Integer carRent, Integer truckRent, Integer money) {
        this.username = username;
        this.password = password;
        this.carRent = carRent;
        this.truckRent = truckRent;
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", carRent=" + carRent +
                ", truckRent=" + truckRent +
                ", money=" + money +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCarRent() {
        return carRent;
    }

    public void setCarRent(Integer carRent) {
        this.carRent = carRent;
    }

    public Integer getTruckRent() {
        return truckRent;
    }

    public void setTruckRent(Integer truckRent) {
        this.truckRent = truckRent;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
