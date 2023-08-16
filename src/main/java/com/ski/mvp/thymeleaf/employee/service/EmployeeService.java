package com.ski.mvp.thymeleaf.employee.service;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.ski.mvp.thymeleaf.config.RestService;
import com.ski.mvp.thymeleaf.employee.domain.Employee;
import com.ski.mvp.thymeleaf.employee.domain.EmployeeSearch;

@Service
public class EmployeeService {
    @Value("${api.springboot.url}")
	private String apiSpringboot;

    @Autowired
    private RestService<Employee[]> employeeListService;

    public List<Employee> searchEmployee(EmployeeSearch keyword) throws Exception {
		return Arrays.asList(this.employeeListService.post(String.format("%s%s", apiSpringboot, "/api/v1/employees/search"), HttpHeaders.EMPTY, keyword, Employee[].class).getBody());
	}
}
