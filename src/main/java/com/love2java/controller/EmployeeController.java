package com.love2java.controller;

import com.love2java.enity.Employee;
import com.love2java.repository.EmployeeRepository;
import com.love2java.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp/v1")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee addEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(addEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long empId) {
        Employee employeeById = employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(employeeById, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployeeDetails() {
        List<Employee> allEmployeeList = employeeService.getAllEmployeeList();
        return new ResponseEntity<>(allEmployeeList, HttpStatus.OK);

    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long empId, @RequestBody Employee employee) {
        employee.setId(empId);
        Employee updateEmp = employeeService.updateEmployee(empId, employee);
        return new ResponseEntity<>(updateEmp, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long empId){
        employeeService.deletEmployee(empId);
        return new ResponseEntity<>("Employee successfully ! deleted with Id = " + empId , HttpStatus.OK);

    }
    @GetMapping("/search") //http://localhost:8081/emp/v1/search?name=Sujeet Sharma
    public ResponseEntity<List<Employee>> searchEmployee(@RequestParam String name)
    {
        List<Employee> employeesResult = employeeRepository.findByempName(name);
        return new ResponseEntity<>(employeesResult,HttpStatus.OK);
    }
    @GetMapping("/empNameAndAddress") //http://localhost:8081/emp/v1/empNameAndAddress?empName=Sujeet Sharma &address=New Delhi
    public ResponseEntity<List<Employee>> getEmployeeAndAddress(@RequestParam String empName,String address)
    {
        List<Employee> byempNameAndAddress = employeeRepository.findByempNameAndAddress(empName, address);
        return new ResponseEntity<>(byempNameAndAddress,HttpStatus.OK);
    }
    @GetMapping("/empNameOrAddress") //http://localhost:8081/emp/v1/empNameOrAddress?empName=Sujeet Sharma&address=New Delhi
    public ResponseEntity<List<Employee>> getEmployeeOrAddress(@RequestParam String empName,String address)
    {
        List<Employee> byempNameOrddress = employeeRepository.findByempNameOrAddress(empName, address);
        return new ResponseEntity<>(byempNameOrddress,HttpStatus.OK);
    }
}


