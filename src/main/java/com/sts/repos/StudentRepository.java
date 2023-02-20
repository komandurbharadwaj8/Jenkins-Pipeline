package com.sts.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.entities.Address;
import com.sts.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	
	
	
	List<Student> findByName(String name);
	
	List<Student> findByCity(String city);

	void deleteById(Address id);
}
