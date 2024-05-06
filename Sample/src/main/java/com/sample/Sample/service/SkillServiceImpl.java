package com.sample.Sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.Sample.entity.Skill;
import com.sample.Sample.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {
	
	@Autowired
	public SkillRepository skillRepository;

	@Override
	public Skill AddSkill(Skill skills) {
		// TODO Auto-generated method stub
		return skillRepository.save(skills);
	}

	@Override
	public List<Skill> getAllSkill() {
		// TODO Auto-generated method stub
		return skillRepository.findAll();
	}
//
//	@Override
//	public List<Skill> getSkillByEmployee(Long employeeId) {
//		// TODO Auto-generated method stub
//		return skillRepository.findByEmployeeId(employeeId);
//	}

}
