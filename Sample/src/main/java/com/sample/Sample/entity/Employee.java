package com.sample.Sample.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
@JsonIdentityInfo(
	      generator = ObjectIdGenerators.PropertyGenerator.class,
	      property = "employeeId")
public class Employee {
	
	//jackson library json to objects viceversa
	//looping is there 
	//
	
	@Id
	private Long employeeId;
	
//parent
	
	@ManyToMany
	@JoinTable(name = "employee-skill",
    joinColumns={
      @JoinColumn(name="empid", referencedColumnName = "employeeId")},
    inverseJoinColumns = {
      @JoinColumn(name="skillid", referencedColumnName = "name")})
	Set<Skill> skills;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}
	
	
	
	/*
	 * 
	 * 3rd table need to define
	 * t1 skill t2 empl
	 * 
	 */

}

//one employee has many skills
//Many employee=java,many skills
//Both side can be possible
