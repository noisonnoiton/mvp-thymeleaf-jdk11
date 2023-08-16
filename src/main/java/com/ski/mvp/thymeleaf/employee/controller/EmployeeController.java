package com.ski.mvp.thymeleaf.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.ski.mvp.thymeleaf.employee.service.EmployeeService;
import com.ski.mvp.thymeleaf.employee.domain.Employee;
import com.ski.mvp.thymeleaf.employee.domain.EmployeeSearch;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees/search")
    public List<Employee> searchEmployee(@RequestBody EmployeeSearch keyword) throws Exception {
        return this.employeeService.searchEmployee(keyword);
    }
}
