package com.sts.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.entities.Student;
import com.sts.entities.StudentSection;

public interface StudentSectionRepo extends JpaRepository<StudentSection, Integer>{
	
	List<StudentSection> findByStudent(Student student);

}
