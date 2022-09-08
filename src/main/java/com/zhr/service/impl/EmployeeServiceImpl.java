package com.zhr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhr.pojo.Employee;
import com.zhr.mapper.EmployeeMapper;
import com.zhr.service.EmployeeService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageInfo<Employee> getEmployeeList(Integer pageNum) {
        PageHelper.startPage(pageNum, 4);
        List<Employee> list = employeeMapper.getEmployeeList();
        return new PageInfo<>(list, 5);
    }

    @Override
    public void add(Employee employee) {
        employeeMapper.add(employee);
    }

    @Override
    public Integer delete(Integer id) {
        return employeeMapper.delete(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeMapper.getAll();
    }

    @Override
    public Employee select(Integer id) {
        return employeeMapper.select(id);
    }
}
