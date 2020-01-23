package com.tcs.employee.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "company")
public class Company {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int periodOfStay;
	
	@Column(name = "employee_id")
	private Long employeeId;
	
	
	
	public Long getEmployee_id() {
		return employeeId;
	}
	public void setEmployee_id(Long employeeId) {
		this.employeeId = employeeId;
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
	public int getPeriodOfStay() {
		return periodOfStay;
	}
	public void setPeriodOfStay(int periodOfStay) {
		this.periodOfStay = periodOfStay;
	}
	
	
}
