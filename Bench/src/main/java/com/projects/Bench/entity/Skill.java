package com.projects.Bench.entity;

import java.util.Objects;

import org.springframework.context.annotation.Bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.ToString;

@ToString
@Entity
@Table(name="skill")
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Pattern(regexp = "^[a-zA-Z ]*$" , message="please provide valid name")
	@Column(name="name")
	private String name;
	
//	@ManyToOne
//    @JoinColumn(name = "employee_id")
//    private Employee employee;
	
	
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(name, skill.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
//	
//	@ManyToOne
//	private Employee employee;
	
	
//	@Bean
//	public Skill skill1() {
//		var ski=new Skill();
//		ski.setName("python");
//		return ski;
//	}
		
	
//	@Bean
//	public Skill skill2() {
//		var ski=new Skill();
//		ski.setName("python");
//		return ski;
//	}

	public Long getId() {
		return id;
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

//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
	
//try

}
