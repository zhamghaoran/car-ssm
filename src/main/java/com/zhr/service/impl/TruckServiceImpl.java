package com.zhr.service.impl;

import com.zhr.mapper.TruckMapper;
import com.zhr.pojo.Truck;
import com.zhr.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TruckServiceImpl implements TruckService {
    @Autowired
    private TruckMapper truckMapper;
    @Override
    public List<Truck> getTruckList() {
        return truckMapper.getTruckLIst();
    }
}
