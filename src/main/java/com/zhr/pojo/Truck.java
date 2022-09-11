package com.zhr.pojo;

public class Truck {
    private Integer id;
    private String bread;
    private String model;
    private String load;
    private Integer price;
    private boolean rentOrNot;
    private String licensePlate;

    public Truck() {
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", bread='" + bread + '\'' +
                ", model='" + model + '\'' +
                ", Load='" + load + '\'' +
                ", price=" + price +
                ", rentOrNot=" + rentOrNot +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Truck(Integer id, String bread, String model, String load, Integer price, boolean rentOrNot, String licensePlate) {
        this.id = id;
        this.bread = bread;
        this.model = model;
        this.load = load;
        this.price = price;
        this.rentOrNot = rentOrNot;
        this.licensePlate = licensePlate;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
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

}
