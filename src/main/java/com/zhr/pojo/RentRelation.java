package com.zhr.pojo;


public class RentRelation {
    private String username;
    private String carType;
    private Integer car_id;

    @Override
    public String toString() {
        return "RentRelation{" +
                "username='" + username + '\'' +
                ", carType='" + carType + '\'' +
                ", car_id=" + car_id +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public RentRelation(String username, String carType, Integer car_id) {
        this.username = username;
        this.carType = carType;
        this.car_id = car_id;
    }
}
