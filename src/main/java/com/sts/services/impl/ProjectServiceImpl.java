package com.sts.services.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.entities.ProjectDetails;
import com.sts.entities.Student;
import com.sts.repos.ProjectRepository;
import com.sts.repos.StudentRepository;
import com.sts.services.ProjectService;



@Service
public class ProjectServiceImpl implements ProjectService{
	
	
	@Autowired
	private StudentRepository studentRepository;

	
	@Autowired
	private ProjectRepository projectRepository;



	@Override
	public ProjectDetails getProject(Integer projectId) {
		
		ProjectDetails project = this.projectRepository.findById(projectId).get();
		return project;
	}

	@Override
	public ProjectDetails addProject(ProjectDetails project, Integer studentId) {
		Student student = this.studentRepository.findById(studentId).get();

		project.setStudent(student);

		ProjectDetails project1 = this.projectRepository.save(project);

		return project1;
	}

	@Override
	public List<ProjectDetails> getProjectOfStudents(Integer studentId) {
		Student student = this.studentRepository.findById(studentId).get();

		return this.projectRepository.findByStudent(student);

	}

	@Override
	public void deleteProject(int projectId) {

		Student student = this.studentRepository.findById(projectId).get();
		this.projectRepository.deleteById(projectId);
		
	}

}
