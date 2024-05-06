package com.projects.Bench.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Long id;
	
	@Pattern(regexp = "^[a-zA-Z ]*$" , message="please enter valid name")
	@Column(name="name",unique=true)
	private String name;
	
	@Digits(integer = 8, fraction = 0, message = "only 8 digits ")
	@Column(name="company_Id",unique = true)
	private Long companyId;
	
	@Pattern(regexp="^[a-zA-Z]{2,8}[0-9]{2,3}@gmail.com$",message="email must have 2-8 letters only,2-3 digits only and end have @gmail.com")
	@Column(name="email",unique=true)
	private String email;
	
	 @OneToMany( cascade = CascadeType.ALL)
	 private Set<Skill> skill = new HashSet<>();
	
	public Long getId() {
		return id;
	}

	public Set<Skill> getSkill() {
		return skill;
	}

	public void setSkill(Set<Skill> skill) {
		this.skill = skill;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	


	public Long getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	
	

}
