package com.sts.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.entities.ProjectDetails;
import com.sts.entities.Student;


public interface ProjectRepository extends JpaRepository<ProjectDetails, Integer>{
	
	
	List<ProjectDetails> findByProjectTitle(String projectTitle);

	List<ProjectDetails> findByStudent(Student student);

}
