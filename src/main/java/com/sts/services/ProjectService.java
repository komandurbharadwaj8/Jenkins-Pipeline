package com.sts.services;

import java.util.List;

import com.sts.entities.ProjectDetails;

public interface ProjectService {
	
	ProjectDetails addProject(ProjectDetails project, Integer studentId);
	
	ProjectDetails getProject(Integer projectId);
	
	List<ProjectDetails> getProjectOfStudents(Integer studentId);
	void deleteProject(int projectId);

}
