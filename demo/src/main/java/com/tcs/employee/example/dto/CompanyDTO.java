package com.tcs.employee.example.dto;


public class CompanyDTO {

	private Long id;
	private String name;
	private int periodOfStay;
	
	private Long employeeId;

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

	public int getPeriodOfStay() {
		return periodOfStay;
	}

	public void setPeriodOfStay(int periodOfStay) {
		this.periodOfStay = periodOfStay;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
	
}
