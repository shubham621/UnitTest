package com.tcs.employee.example.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tcs.employee.example.dto.CompanyDTO;
import com.tcs.employee.example.dto.EmployeeDTO;
import com.tcs.employee.example.exception.TCSException;
import com.tcs.employee.example.model.Company;
import com.tcs.employee.example.model.Employee;
import com.tcs.employee.example.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
//@SpringBootTest
@ContextConfiguration(classes = { EmployeeServiceImpl.class, ExpectedException.class })
public class ServiceUnitTest {

	@Autowired
	private EmployeeServiceImpl empImpl;

	@MockBean
	private EmployeeRepository empRepository;

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void testCreateEmployee() throws TCSException {

		// EmployeeServiceImpl empImpl = new EmployeeServiceImpl();

		ModelMapper mapper = new ModelMapper();

		Employee expectedResult = mapper.map(createTestDTO(), Employee.class);
		expectedResult.setId(1l);
		long i = 0;
		for (Company company : expectedResult.getCompanyList()) {
			i++;
			company.setId(i);
		}

		Mockito.when(empRepository.save(Mockito.any(Employee.class))).thenReturn(expectedResult);

		assertThat(empImpl.createEmployee(createTestDTO())).isEqualTo(1);
	}

	@Test
	public void testCreateEmployee_Exception() throws TCSException {

		// EmployeeServiceImpl empImpl = new EmployeeServiceImpl();

		exceptionRule.expect(TCSException.class);

		exceptionRule.expectMessage("Age Should be less than 60");

		ModelMapper mapper = new ModelMapper();

		EmployeeDTO employeeDTO = createTestDTO();

		employeeDTO.setAge(68);

		empImpl.createEmployee(employeeDTO);

		// assertThat(empImpl.createEmployee(createTestDTO())).isEqualTo(1);
	}

	private EmployeeDTO createTestDTO() {

		EmployeeDTO employeeDTO = new EmployeeDTO();
		CompanyDTO companyDTO1 = new CompanyDTO();
		CompanyDTO companyDTO2 = new CompanyDTO();

		employeeDTO.setAge(45);
		employeeDTO.setEmailAddres("abc@tcs.com");
		employeeDTO.setName("Test User");

		companyDTO1.setName("TCS");
		companyDTO1.setPeriodOfStay(2);

		companyDTO2.setName("AIA");
		companyDTO2.setPeriodOfStay(3);

		List<CompanyDTO> companyDTOList = new ArrayList<CompanyDTO>();

		companyDTOList.add(companyDTO1);
		companyDTOList.add(companyDTO2);

		employeeDTO.setCompanyList(companyDTOList);

		// employeeService.

		return employeeDTO;

	}

}
