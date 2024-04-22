package com.projects.Bench.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.Bench.entity.Skill;
import com.projects.Bench.repository.SkillRepository;

@Service
public class SkillDao {

	
	private SkillRepository skillrepository;
	
	@Autowired
	public SkillDao(SkillRepository skillrepository) {
		this.skillrepository = skillrepository;
	}
	
	public Skill createSkill(Skill skill) {
		return skillrepository.save(skill);
	}
	
	public List<Skill> getAllSkill(){
		return skillrepository.findAll();
	}
	
	public void DeleteSkillById(Long id) {
		skillrepository.deleteById(id);
	}
	
	public Skill getSkillById(Long id) {
	    return skillrepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Error message: Skill with ID " + id + " not found"));
	}
	
}
