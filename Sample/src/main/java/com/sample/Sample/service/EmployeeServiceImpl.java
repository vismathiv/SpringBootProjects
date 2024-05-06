package com.sample.Sample.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.Sample.entity.Employee;
import com.sample.Sample.entity.Skill;
import com.sample.Sample.repository.EmployeeRepository;
import com.sample.Sample.repository.SkillRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	@Autowired
	public SkillRepository skillRepository;

	@Override
	public Employee AddEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Set<Employee> findSkillEmployee(String name) {
		// TODO Auto-generated method stub
		Skill skill=skillRepository.findByName(name);
		if(skill!=null) {
			return skill.getEmployees();
		}else {
            return new HashSet<>();
        }
	}

}
