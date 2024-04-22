package com.projects.Bench.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.projects.Bench.entity.Skill;

public interface SkillService {
	
	public ResponseEntity<String> createSkill(Skill skill);
	
	public ResponseEntity<List<Skill>> getAllSkill();
	
	public ResponseEntity<String> DeleteSkillById(Long id);
	
	public ResponseEntity<Skill> getSkillById(Long Id);

}
