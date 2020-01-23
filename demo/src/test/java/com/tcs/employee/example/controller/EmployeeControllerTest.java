package com.tcs.employee.example.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.employee.example.controller.EmployeeController;
import com.tcs.employee.example.dto.EmployeeDTO;
import com.tcs.employee.example.exception.TCSException;
import com.tcs.employee.example.service.EmployeeService;
import com.tcs.employee.example.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class)
//@AutoConfigureMockMvc
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private EmployeeService employeeService;
	
	//@Rule
	

	@Test
	public void testCreateEmployee() throws Exception {

		Mockito.when(employeeService.createEmployee(Mockito.any(EmployeeDTO.class))).thenReturn(2l);

		ObjectMapper objectMapper = new ObjectMapper();

		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setAge(45);

		// mapper.
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/create/employee")
				.accept(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(employeeDTO))
				.contentType(MediaType.APPLICATION_JSON_VALUE);

		ResultActions result = mockMvc.perform(requestBuilder);

		result.andDo(print());
		result.andExpect(status().isCreated());
		// result.andExpect(content().)

		assertThat(result.andReturn().getResponse().getContentAsString()).isEqualTo("2");

	}

	@Test
	public void testGetEmployeeByID() throws Exception {

		EmployeeDTO empDto = new EmployeeDTO(2l, "Test Emp", 20, "test@abc.com");

		// EmployeeDTO empDto2 = new EmployeeDTO(2l, "Test Emp", 20, "test@abc.com");

		ObjectMapper objectMapper = new ObjectMapper();

		String expectedRespone = objectMapper.writeValueAsString(empDto);

		Mockito.when(employeeService.findByEmployeeId(2l)).thenReturn(empDto);

		RequestBuilder request = MockMvcRequestBuilders.get("/find/employee/2")
				.accept(MediaType.APPLICATION_JSON_VALUE);

		ResultActions result = mockMvc.perform(request);

		result.andDo(print());
		result.andExpect(status().isOk());

		assertThat(result.andReturn().getResponse().getContentAsString()).isEqualTo(expectedRespone);

	}

}
