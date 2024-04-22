package com.projects.Bench.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.Bench.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Optional<Employee> findByName(String name);
	Optional<Employee> findByCompanyId(Long id);
	Optional<Employee> findByEmail(String email);
	
}
