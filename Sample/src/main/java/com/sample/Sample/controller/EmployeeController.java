package com.sample.Sample.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.Sample.entity.Employee;
import com.sample.Sample.service.EmployeeService;

@RestController
@RequestMapping("/api/employeemap")
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	
	@PostMapping
	public Employee AddEmployee(@RequestBody Employee employee) {
		return employeeService.AddEmployee(employee);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployee();
	}

	@GetMapping("/employees/skillval")
	public ResponseEntity<Set<Employee>> findSkillEmployee(@RequestParam("skill") String name){
		Set<Employee> employees=employeeService.findSkillEmployee(name);
		return ResponseEntity.ok(employees);
	}
}
