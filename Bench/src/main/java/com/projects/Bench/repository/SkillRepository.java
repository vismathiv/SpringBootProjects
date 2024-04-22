package com.projects.Bench.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.Bench.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill,Long>{

	Optional<Skill> findByName(String name);
}
