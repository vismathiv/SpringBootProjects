package com.sample.Sample.service;

import java.util.List;

import com.sample.Sample.entity.Skill;

public interface SkillService {
	
	public Skill AddSkill(Skill skills);
	
	public List<Skill> getAllSkill();
	
	//public List<Skill> getSkillByEmployee(Long employeeId);

}
