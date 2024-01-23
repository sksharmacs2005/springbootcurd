package com.love2java.repository;

import com.love2java.enity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByempName(String name);

    List<Employee> findByempNameAndAddress(String empName,String address);

}
