package com.sts.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.entities.ProjectDetails;
import com.sts.entities.Student;
import com.sts.services.ProjectService;

@RestController
@RequestMapping("/Project")
@CrossOrigin("*")
public class ProjectController {
	
	@Autowired
	private ProjectService ProjectService;
	
	@PostMapping("/post")
	public ResponseEntity<ProjectDetails> addProject(@PathVariable Integer ProjectId,@RequestBody ProjectDetails Project)
	{
		ProjectDetails addedProject = ProjectService.addProject(Project,ProjectId);
		return new ResponseEntity<ProjectDetails>(addedProject, HttpStatus.CREATED);
	
		
	}
	
	@GetMapping("/project")
	public ResponseEntity<List<ProjectDetails>> getAllByStudent(@PathVariable Integer ProjectId) {
		
		
		return ResponseEntity.ok(this.ProjectService.getProjectOfStudents(ProjectId));
	}

	@DeleteMapping("/{projectId}")
	public ResponseEntity<Map<String, Object>> deleteStudent(@PathVariable Integer ProjectId) {
		this.ProjectService.deleteProject(ProjectId);
		return new ResponseEntity<>(Map.of("message", "project deleted successfully"), HttpStatus.OK);
	}

}
