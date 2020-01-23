package com.tcs.employee.example.service;

import com.tcs.employee.example.dto.EmployeeDTO;
import com.tcs.employee.example.exception.TCSException;

public interface EmployeeService {

	public Long createEmployee(EmployeeDTO employeeDTO) throws TCSException;
	public EmployeeDTO findByEmployeeId(Long employeeId) throws TCSException;
	
}
