package com.tcs.employee.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.employee.example.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
