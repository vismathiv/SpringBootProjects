package com.projects.Bench.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projects.Bench.dao.EmployeeDao;
import com.projects.Bench.entity.Employee;
import com.projects.Bench.entity.Skill;
import com.projects.Bench.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeDao employeeDao;

	@Override
	public ResponseEntity<String> createEmployee(Employee employee) {
		employee.setName(employee.getName().toLowerCase());
		 Optional<Employee> exists = employeeRepository.findByName(employee.getName());
		 Optional<Employee> exists1=employeeRepository.findByCompanyId(employee.getCompanyId());
		 Optional<Employee> existes2=employeeRepository.findByEmail(employee.getEmail());
		 if(exists.isPresent()) {
			 return ResponseEntity.badRequest().body("Already exists, Fetching employee name :"+employee.getName()); 
		 }else if(exists1.isPresent()) {
			 return ResponseEntity.badRequest().body("Already Company Id exists, Fetching company Id :"+employee.getCompanyId()); 
		 }else if(existes2.isPresent()) {
			 return ResponseEntity.badRequest().body("Already Email exists, Fetching employee Email :"+employee.getEmail()); 
		 }
		 else {
			 Set<Skill> dupl = new HashSet<>();
			    for (Skill skill : employee.getSkill()) {
			        if (!dupl.add(skill)) {
			            return ResponseEntity.badRequest().body("Duplicate skill: " + skill.getName());
			        }
			   }
			 employeeDao.createEmployee(employee);
			 return ResponseEntity.status(HttpStatus.CREATED).body("Employee is successfully created");
		 }
		
	}

	@Override
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employees=employeeDao.getAllEmployee();
		return ResponseEntity.ok().body(employees);
	}

	@Override
	public ResponseEntity<String> deleteEmployee(Long id) {
		employeeDao.deleteEmployee(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
	}
	

}
