package com.projects.Bench.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.projects.Bench.entity.Employee;

public interface EmployeeService {

	public ResponseEntity<String> createEmployee(Employee employee);
	
	public ResponseEntity<List<Employee>> getAllEmployee();
	
	public ResponseEntity<String> deleteEmployee(Long id);
	
	//public ResponseEntity<Employee> getEmployeeBycompanyId(Long companyId);

	public ResponseEntity<Employee> getEmployeeBycompanyId(Long companyId);
}
