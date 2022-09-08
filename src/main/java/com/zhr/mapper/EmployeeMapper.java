package com.zhr.mapper;

import com.zhr.pojo.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeMapper {
    List<Employee> getEmployeeList();

    void add(Employee employee);

    Integer delete(Integer id);

    List<Employee> getAll();

    Employee select(Integer id);


}
