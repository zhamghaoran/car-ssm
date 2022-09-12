package com.zhr.service.impl;

import com.zhr.mapper.CarMapper;
import com.zhr.pojo.Car;
import com.zhr.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;
    @Override
    public List<Car> getCarList() {
        List<Car> carList = carMapper.getCarList();
        return carList;
    }
}
