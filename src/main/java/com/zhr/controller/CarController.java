package com.zhr.controller;

import com.zhr.pojo.Car;
import com.zhr.service.CarService;
import com.zhr.utils.response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("/car/carlist")
    public response getCarList() {
        String status = "200";
        String message = "OK";
        List<Car> carList = carService.getCarList();
        HashMap<String , List<Car>> carMap = new HashMap<>();
        carMap.put("CarList",carList);
        return new response(status, message, carMap);
    }



}
