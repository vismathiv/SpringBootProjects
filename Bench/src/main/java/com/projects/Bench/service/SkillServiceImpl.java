package com.projects.Bench.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projects.Bench.dao.SkillDao;
import com.projects.Bench.entity.Skill;
import com.projects.Bench.repository.SkillRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SkillServiceImpl implements SkillService{

	
	//dao 
	//part of dao layer save method should be from dao layer.
	//
	
	@Autowired
	private SkillRepository skillrepository;
	
	@Autowired
	public SkillDao skillDao;
	
	@Override
	public ResponseEntity<String> createSkill(Skill skill) {
		
		skill.setName(skill.getName().toLowerCase());
		
        Optional<Skill> exists = skillrepository.findByName(skill.getName());
		if (exists.isPresent()) {
            return ResponseEntity.badRequest().body("Already exists, Fetching skill name :"+skill.getName()); 
        } 
        else {
        	skillDao.createSkill(skill);
            return ResponseEntity.status(HttpStatus.CREATED).body("Skill is successfully created");
        }

		
	}

	
	@Override
	public ResponseEntity<List<Skill>> getAllSkill() {
	    List<Skill> skills = skillDao.getAllSkill();
	    Set<String> uniqueSkillNames = new HashSet<>();
	    List<Skill> distinctSkills = new ArrayList<>();
	    
	    for (Skill skill : skills) {
	        if (!uniqueSkillNames.contains(skill.getName())) {
	            
	            distinctSkills.add(skill);
	            uniqueSkillNames.add(skill.getName());
	        }
	    }
	    return ResponseEntity.ok().body(distinctSkills); 
	}


	@Override
	public ResponseEntity<String> DeleteSkillById(Long id) {
		skillDao.DeleteSkillById(id);
		return ResponseEntity.ok().body("Deleted successfully of Skill ID : "+id);
	}



	@Override
	public ResponseEntity<Skill> getSkillById(Long id) {
	    Skill skill = skillDao.getSkillById(id);
	    if (skill != null) {
	        return ResponseEntity.ok().body(skill);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	
	//return a list of skills instead to toString
	//Add api to delete a Skill By ID(Return Status message).
	//Fetch a Skill By ID 
	
	//JSON object always to frontend 
	
	//add skill stores in database
	//
	 
	
}
