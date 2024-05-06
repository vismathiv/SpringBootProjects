package com.sample.Sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.Sample.entity.Skill;
import com.sample.Sample.service.SkillService;

@RestController
@RequestMapping("/api/skillmap")
public class SkillController {

	@Autowired
	public SkillService skillService;
	
	@PostMapping
	public Skill AddSkill(@RequestBody Skill skills) {
		return skillService.AddSkill(skills);
	}
	
	@GetMapping
	public List<Skill> getAllSkill(){
		return skillService.getAllSkill();
	}
	
	
//	@GetMapping("/api/employeemap/{employeeId}")
//	public List<Skill> getSkillByEmployee(Long employeeId){
//		return skillService.getSkillByEmployee(employeeId);
//	}
}


//emp -skill
/*stack over flow 
 * 
*/
