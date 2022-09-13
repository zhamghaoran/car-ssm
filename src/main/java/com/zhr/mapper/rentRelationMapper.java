package com.zhr.mapper;

import com.zhr.pojo.RentRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface rentRelationMapper {
    List<RentRelation> getRentList() ;

    List<RentRelation> selectRentListByUsername(@Param("username") String username);

    void Insert(@Param("username") String username,@Param("carType") String type,@Param("car_id")Integer car_id);

    void Delete(@Param("username") String username,@Param("carType") String type,@Param("car_id")Integer car_id);
}
