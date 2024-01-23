package com.love2java.service;

import com.love2java.enity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    Employee getEmployeeById(Long empId);

    List<Employee> getAllEmployeeList();

    Employee updateEmployee(Long empId,Employee employee);

    void deletEmployee(Long empId);

}
