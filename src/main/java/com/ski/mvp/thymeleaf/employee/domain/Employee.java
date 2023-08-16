package com.ski.mvp.thymeleaf.employee.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Employee {
    private long id;
    private String name;
    private String email;
    private String bloodType;
    private String gender;
    private String ipAddress;
    private String phone;
    private String companyName;
    private String jobTitle;
    private String university;
    private String ssn;
}
