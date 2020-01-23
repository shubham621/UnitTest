package com.tcs.employee.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.employee.example.dto.EmployeeDTO;
import com.tcs.employee.example.exception.TCSException;
import com.tcs.employee.example.service.EmployeeService;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/test" , method = RequestMethod.GET)
	public String test() {
		return "Hello";
	}
	
	
	@RequestMapping(value = "/create/employee" , method = RequestMethod.POST ,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> createEmployee(@RequestBody EmployeeDTO empDTO) throws TCSException{
	
		return new ResponseEntity<Long>(employeeService.createEmployee(empDTO), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/find/employee/{id}" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDTO> findEmployeeById(@PathVariable Long id) throws TCSException{
	
		return new ResponseEntity<EmployeeDTO>(employeeService.findByEmployeeId(id), HttpStatus.OK);
	}

}
