package com.tcs.employee.example.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.employee.example.DemoApplication;
import com.tcs.employee.example.dto.CompanyDTO;
import com.tcs.employee.example.dto.EmployeeDTO;
import com.tcs.employee.example.model.Employee;
import com.tcs.employee.example.repository.EmployeeRepository;
import com.tcs.employee.example.service.EmployeeService;
import com.tcs.employee.example.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@TestPropertySource(locations= {})
public class EmployeeControllerIntegrationTest {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private MockMvc mockMvc;

	// @Spy

	/*
	 * @MockBean private EmployeeRepository employeeRepository;
	 */

	@Before
	public void setup() {
	}

	@Test
	public void testCreateEmployee() throws Exception {

		// em
		// Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(2l);

		ObjectMapper objectMapper = new ObjectMapper();

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/create/employee")
				.accept(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(createTestDTO()))
				.contentType(MediaType.APPLICATION_JSON_VALUE);

		ResultActions result = mockMvc.perform(requestBuilder);

		result.andDo(print());
		result.andExpect(status().isCreated());
		// result.andExpect(content().)

		assertThat(result.andReturn().getResponse().getContentAsString()).isEqualTo("1");

	}

	@Test
	public void findByIdTest() throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();

		EmployeeDTO expectedDto = createTestDTO();

		expectedDto.setId(1l);
		long i = 0;
		for (CompanyDTO comDto : expectedDto.getCompanyList()) {
			i++;
			comDto.setId(i);

		}

		String expectedRespone = objectMapper.writeValueAsString(expectedDto);

		// Mockito.when(employeeService.findByEmployeeId(2l)).thenReturn(empDto);

		RequestBuilder request = MockMvcRequestBuilders.get("/find/employee/1")
				.accept(MediaType.APPLICATION_JSON_VALUE);

		ResultActions result = mockMvc.perform(request);

		result.andDo(print());
		result.andExpect(status().isOk());

		assertThat(result.andReturn().getResponse().getContentAsString()).isEqualTo(expectedRespone);
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
