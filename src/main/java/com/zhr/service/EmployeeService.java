package com.zhr.service;

import com.github.pagehelper.PageInfo;
import com.zhr.pojo.Employee;

public interface EmployeeService {
    PageInfo<Employee> getEmployeeList(Integer pageNum);

    void add(Employee employee);}
