package com.tcs.employee.example.dto;

import java.util.List;



public class EmployeeDTO {

	private Long id;
	private String name;
	private int age;
	private String emailAddres;
	
	List<CompanyDTO> companyList;
	
	

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(Long id, String name, int age, String emailAddres) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.emailAddres = emailAddres;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailAddres() {
		return emailAddres;
	}

	public void setEmailAddres(String emailAddres) {
		this.emailAddres = emailAddres;
	}

	public List<CompanyDTO> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<CompanyDTO> companyList) {
		this.companyList = companyList;
	}

	

}
