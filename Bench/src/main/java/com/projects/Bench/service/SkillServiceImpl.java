package com.projects.Bench.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projects.Bench.dao.SkillDao;
import com.projects.Bench.entity.Skill;
import com.projects.Bench.repository.SkillRepository;

@Service
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
		//skill.getEmployee().getId()
//        Optional<Skill> exists = skillrepository.findByName(skill.getName());
//		if (exists.isPresent()) {
//            return ResponseEntity.badRequest().body("Already exists, Fetching skill name :"+skill.getName()); 
//        } 
//        else {
        	skillDao.createSkill(skill);
            return ResponseEntity.status(HttpStatus.CREATED).body("Skill is successfully created");
//        }

		
	}

	
	@Override
	public ResponseEntity<List<Skill>> getAllSkill() {
	    List<Skill> skills = skillDao.getAllSkill();
	    return ResponseEntity.ok().body(skills); 
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
	 
	
}
