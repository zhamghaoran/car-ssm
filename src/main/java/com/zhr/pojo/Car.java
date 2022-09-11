package com.zhr.pojo;

public class Car {
    private Integer id;
    private String bread;
    private Integer price;
    private boolean rentOrNot;
    private String licensePlate;
    private String model;

    public Car() {
    }

    public Car(Integer id, String bread, Integer price, boolean rentOrNot, String licensePlate, String model) {
        this.id = id;
        this.bread = bread;
        this.price = price;
        this.rentOrNot = rentOrNot;
        this.licensePlate = licensePlate;
        this.model = model;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", bread='" + bread + '\'' +
                ", price=" + price +
                ", rentOrNot=" + rentOrNot +
                ", licensePlate='" + licensePlate + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isRentOrNot() {
        return rentOrNot;
    }

    public void setRentOrNot(boolean rentOrNot) {
        this.rentOrNot = rentOrNot;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
