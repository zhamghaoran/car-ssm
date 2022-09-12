package com.zhr.mapper;

import com.zhr.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {
    List<Car> getCarList();

    Car getCar(@Param("id") Integer id);

    Integer rentCar(@Param("carId") Integer carId);

    Integer returnCar(@Param("carId") Integer carId);

}
