package com.zhr.service;

import com.github.pagehelper.PageInfo;
import com.zhr.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    PageInfo<Employee> getEmployeeList(Integer pageNum);

    void add(Employee employee);

    Integer delete(Integer id);

    List<Employee> getAll();

    Employee select(Integer id);
}
