package com.ski.mvp.thymeleaf.employee.controller;

import java.util.HashMap;
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
@RequestMapping("/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/search")
    public List<Employee> searchEmployee(@RequestBody EmployeeSearch keyword) throws Exception {
        return this.employeeService.searchEmployee(keyword);
    }

    @PostMapping("/chart/gender")
    public List<HashMap<String, Object>> chartEmployeeGender(@RequestBody HashMap<String, Object> keyword) throws Exception {
        return this.employeeService.chartEmployeeGender(keyword);
    }
    @PostMapping("/chart/bloodtype")
    public List<HashMap<String, Object>> chartEmployeeBloodType(@RequestBody HashMap<String, Object> keyword) throws Exception {
        return this.employeeService.chartEmployeeBloodType(keyword);
    }
    @PostMapping("/chart/combination")
    public List<HashMap<String, Object>> chartEmployeeCombination(@RequestBody HashMap<String, Object> keyword) throws Exception {
        return this.employeeService.chartEmployeeCombination(keyword);
    }
}
