package com.tcs.employee.example.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tcs.employee.example.dto.EmployeeDTO;
import com.tcs.employee.example.exception.TCSException;
import com.tcs.employee.example.model.Employee;
import com.tcs.employee.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;


	@Override
	@Transactional
	public Long createEmployee(EmployeeDTO employeeDTO) throws TCSException {

		if (employeeDTO.getAge() > 60) {
			throw new TCSException(HttpStatus.EXPECTATION_FAILED, "Age Should be less than 60");
		}

		ModelMapper modelMapper = new ModelMapper();
		
		Employee emp = modelMapper.map(employeeDTO, Employee.class);

		Employee savedEmployee = employeeRepository.save(emp);

		if (savedEmployee == null || savedEmployee.getId() == null || savedEmployee.getId() == 0) {
			throw new TCSException(HttpStatus.INTERNAL_SERVER_ERROR, "Employee not saved please try later");
		}

		return savedEmployee.getId();
	}

	@Override
	public EmployeeDTO findByEmployeeId(Long employeeId) throws TCSException {

		Optional<Employee> searchResult = employeeRepository.findById(employeeId);
		ModelMapper modelMapper = new ModelMapper();

		if (searchResult.isPresent()) {

			return modelMapper.map(searchResult.get(), EmployeeDTO.class);

		} else {
			throw new TCSException(HttpStatus.NOT_FOUND, "Employee with id " + employeeId + " not found");
		}

	}

	public String simpleMethod(String simpleInput) {

		if (simpleInput.equalsIgnoreCase("Hello")) {
			return "Hello welcome to Spring Boot Test";
		} else if (simpleInput.equalsIgnoreCase("Hi")) {
			return "Hello welcome to Junit and Mockito";
		} else {
			return simpleInput;
		}

	}

}
