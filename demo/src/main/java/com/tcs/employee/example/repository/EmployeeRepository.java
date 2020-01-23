package com.tcs.employee.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.employee.example.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
