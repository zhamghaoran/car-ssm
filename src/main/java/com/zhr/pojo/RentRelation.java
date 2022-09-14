package com.zhr.pojo;


import java.sql.Date;

public class RentRelation {
    private String username;
    private String carType;
    private Integer id;

    private Car car;
    public RentRelation(){}

    @Override
    public String toString() {
        return "RentRelation{" +
                "username='" + username + '\'' +
                ", carType='" + carType + '\'' +
                ", car_id=" + id +
                ", car=" + car +
                '}';
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    // Integer car_id, Integer carId, String bread, Integer price, boolean rentOrNot, String licensePlate, String model, Date rentTime
    public RentRelation(String username, String carType,Integer car_id, Car car) {
        this.username = username;
        this.carType = carType;
        this.id = car_id;
        this.car = car;
        //this.car = car;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
