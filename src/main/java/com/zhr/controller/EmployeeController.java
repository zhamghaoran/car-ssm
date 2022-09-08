package com.zhr.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.JsonArray;
import com.zhr.pojo.Employee;
import com.zhr.service.EmployeeService;
import com.zhr.utils.response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @RequestMapping("/select")
    public PageInfo<Employee> select() {
        return employeeService.getEmployeeList(1);
    }

    @RequestMapping("/add")
    public String add(Employee employee) {
        employeeService.add(employee);
        return "ok";
    }
    @RequestMapping("/delete")
    public String delete(Integer id) {
        Integer status = employeeService.delete(id);
        if (status == 0) {
            return "fail";
        } else
            return "success";

    }
    @RequestMapping("/getall")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
    @RequestMapping("/select/one")
    public Object select(Integer id) {
        Employee select = employeeService.select(id);
        if (select == null) {
            response response = new response();
            response.reason = "查无此人";
            response.status = "Http.statusOK";
            return response;
        }
        return select;
    }

}
