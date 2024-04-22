package com.projects.Bench.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.Bench.entity.Skill;
import com.projects.Bench.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {
	
	@Autowired
	SkillService skillService;
	
	@PostMapping
	public ResponseEntity<String> createSkill(@RequestBody Skill skill) {
		return skillService.createSkill(skill);
	}
	
	@GetMapping
	public ResponseEntity<List<Skill>> getAllSkill(Skill skill){
		return skillService.getAllSkill();
				
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteSkillById(@PathVariable("id") Long id){
		return skillService.DeleteSkillById(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Skill> getSkillById(@PathVariable Long id){
	    ResponseEntity<Skill> skills = skillService.getSkillById(id);
	    return skills;
	}
	
	@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleNotFoundException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        
    }

}
