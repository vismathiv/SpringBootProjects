package com.projects.Bench.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.Bench.entity.Employee;
import com.projects.Bench.entity.Skill;
import com.projects.Bench.service.EmployeeService;

@Validated
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	
	@PostMapping
	ResponseEntity<String> createEmployee(@RequestBody Employee employee){
		return employeeService.createEmployee(employee);
		
	}
	
	@GetMapping
	ResponseEntity<List<Employee>> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<String> deleteEmployee(@PathVariable Long id){
		return employeeService.deleteEmployee(id);
	}
	
}
