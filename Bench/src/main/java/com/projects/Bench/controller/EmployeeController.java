package com.projects.Bench.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.Bench.entity.Employee;
import com.projects.Bench.entity.Skill;
import com.projects.Bench.repository.EmployeeRepository;
import com.projects.Bench.service.EmployeeService;

import jakarta.validation.Valid;

//@Validated
@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:3000")
public class EmployeeController {
	
	@Autowired
	public EmployeeService employeeService;
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	@PostMapping
	ResponseEntity<String> createEmployee(@Valid @RequestBody Employee employee){
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
	
	@GetMapping("/{companyId}")
	ResponseEntity<Employee> getEmployeeBycompanyId(@PathVariable("companyId") Long companyId){
		ResponseEntity<Employee> employee=employeeService.getEmployeeBycompanyId(companyId);
		return employee;
	}
	
	
	@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleNotFoundException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        
    }
}
