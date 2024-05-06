package com.projects.Bench.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.Bench.entity.Employee;
import com.projects.Bench.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeDao {
	
	private EmployeeRepository employeeRepository;
	
	
	@Autowired
	public EmployeeDao(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAllEmployee(){
		return  employeeRepository.findAll();
	}
	
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
	
	/*public Employee getEmployeeBycompanyId(Long companyId) {
		return employeeRepository.findByCompanyId(companyId)
	            .orElseThrow(() -> new RuntimeException("Error message: Employee with ID " + companyId + " not found"));
	}*/

	public Employee getEmployeeBycompanyId(Long companyId) {
		return employeeRepository.findByCompanyId(companyId)
	            .orElseThrow(() -> new RuntimeException("Error message: Employee with ID " + companyId + " not found"));
	}
	

}
