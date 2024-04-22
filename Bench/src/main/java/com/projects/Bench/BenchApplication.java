package com.projects.Bench;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.projects.Bench.entity.Skill;

@SpringBootApplication
public class BenchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BenchApplication.class, args);
		
//		var context=new AnnotationConfigApplicationContext(Skill.class);
//		System.out.println(context.getBean("skill1"));
	}
	
	//@controller @response body. 
	//composite annotation of  @controller and @responsebody @restcontroller= 
	//@controller,,,, which returns json object @response body converts java object to json object
	//@Rest Controller have always reponsebody..
	//@component = generic annotation.

}
