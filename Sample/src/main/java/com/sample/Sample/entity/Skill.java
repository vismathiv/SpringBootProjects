package com.sample.Sample.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="skill")
@JsonIdentityInfo(
	      generator = ObjectIdGenerators.PropertyGenerator.class,
	      property = "name")
public class Skill {
	
	//helps in stoping of continous objects
	
	@Id
	private String name;
	
	//bidrectional 
	//one skill 
	@ManyToMany (mappedBy = "skills", fetch = FetchType.EAGER,
		      targetEntity = Employee.class, cascade = CascadeType.PERSIST)
	Set<Employee> employees;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
	//api will take input from frotened name of language we need to return all employees.
	//we look for skills 
	//take list of skills, give back list of employees. //bidrectional 
	//jackson library
	// 

}
