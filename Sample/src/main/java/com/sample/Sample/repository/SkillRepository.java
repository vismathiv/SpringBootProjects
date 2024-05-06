package com.sample.Sample.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.Sample.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, String>{

	//public List<Skill> findByEmployeeId(Long employeeId);
	public Skill findByName(String name);
}
