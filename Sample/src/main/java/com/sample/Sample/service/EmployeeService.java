package com.sample.Sample.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sample.Sample.entity.Employee;


public interface EmployeeService {

	public Employee AddEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public Set<Employee> findSkillEmployee(String name);
}
