package com.zhr.mapper;

import com.zhr.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface CarMapper {
    List<Car> getCarList();

    Car getCar(@Param("id") Integer id);

    void rentCar(@Param("carId") Integer carId, @Param("date")Date date);

    void returnCar(@Param("carId") Integer carId);

}
