package com.tcs.employee.example.controller.simple;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.tcs.employee.example.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class) // We will ask spring runner to run the test instead of Junit Runner
public class SimpleMethodTest {

	private EmployeeServiceImpl serviceImpl = new EmployeeServiceImpl();

	@Test
	public void testSimpleMethod() {

		String output1 = serviceImpl.simpleMethod("Hello");
		String output2 = serviceImpl.simpleMethod("Hi");
		String output3 = serviceImpl.simpleMethod("Hello Hi");
		
		assertThat(output1).isEqualTo("Hello welcome to Spring Boot Test"); // Assert Statement is Used from AssertJ Library it comes with
														// Spring Boot Starter Test Dependency
		
		assertThat(output2).isEqualTo("Hello welcome to Junit and Mockito");
		
		assertThat(output3).isEqualTo("Hello Hi");
		
		
	}

}