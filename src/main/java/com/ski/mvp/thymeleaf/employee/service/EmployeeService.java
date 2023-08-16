package com.ski.mvp.thymeleaf.employee.service;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.ski.mvp.thymeleaf.config.RestService;
import com.ski.mvp.thymeleaf.employee.domain.Employee;
import com.ski.mvp.thymeleaf.employee.domain.EmployeeSearch;

@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class EmployeeService {
    @Value("${api.springboot.url}")
	private String apiSpringboot;

    private String apiEmployee = "/api/v1/employees";

    @Autowired
    private RestService<Employee[]> employeeSearchService;

    @Autowired
    private RestService<HashMap[]> employeeChartService;

    public List<Employee> searchEmployee(EmployeeSearch keyword) throws Exception {
		return Arrays.asList(this.employeeSearchService.post(String.format("%s%s%s", apiSpringboot, apiEmployee, "/search"), HttpHeaders.EMPTY, keyword, Employee[].class).getBody());
	}

    public List<HashMap<String, Object>> chartEmployeeGender(HashMap<String, Object> keyword) throws Exception {
		return Arrays.asList(this.employeeChartService.post(String.format("%s%s%s", apiSpringboot, apiEmployee, "/chart/gender"), HttpHeaders.EMPTY, keyword, HashMap[].class).getBody());
	}

    public List<HashMap<String, Object>> chartEmployeeBloodType(HashMap<String, Object> keyword) throws Exception {
		return Arrays.asList(this.employeeChartService.post(String.format("%s%s%s", apiSpringboot, apiEmployee, "/chart/bloodtype"), HttpHeaders.EMPTY, keyword, HashMap[].class).getBody());
	}

    public List<HashMap<String, Object>> chartEmployeeCombination(HashMap<String, Object> keyword) throws Exception {
		return Arrays.asList(this.employeeChartService.post(String.format("%s%s%s", apiSpringboot, apiEmployee, "/chart/combination"), HttpHeaders.EMPTY, keyword, HashMap[].class).getBody());
	}
}
