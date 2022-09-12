package com.zhr.mapper;

import com.zhr.pojo.Car;

import java.util.List;

public interface CarMapper {
    List<Car> getCarList();

    Car getCar(Integer id);

}
