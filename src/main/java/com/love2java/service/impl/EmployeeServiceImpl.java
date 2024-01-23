package com.love2java.service.impl;

import com.love2java.enity.Employee;
import com.love2java.exception.EmployeeNotFoundException;
import com.love2java.repository.EmployeeRepository;
import com.love2java.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long empId) {
        Optional<Employee> employeeId = employeeRepository.findById(empId);
         return employeeId.get();
    }

    @Override
    public List<Employee> getAllEmployeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long empId,Employee employee) {

        Employee existingEmployee = employeeRepository.findById(empId).orElse(null);
        if(existingEmployee!=null)
        {
            existingEmployee.setEmpName(employee.getEmpName());
            existingEmployee.setAddress(employee.getAddress());
            return employeeRepository.save(existingEmployee);
        }else {
            throw new EmployeeNotFoundException("Employee is not exit = " + empId);
        }


    }

    @Override
    public void deletEmployee(Long empId) {
        employeeRepository.deleteById(empId);

    }

 }
