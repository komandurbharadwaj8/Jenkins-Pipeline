package com.sts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.entities.StudentSection;
import com.sts.services.StudentSectionService;

@RestController
@RequestMapping("/students/{studentId}")
@CrossOrigin("*")
public class StudentSectionController {
	
	@Autowired
	private StudentSectionService studentSectionService;
	
	
	@PostMapping("/studentsections")
	public ResponseEntity<?> addStudentSection(@PathVariable Integer studentId, @RequestBody StudentSection studentsection) {
		StudentSection addStudentSection = this.studentSectionService.addStudentSection(studentsection, studentId);
		return ResponseEntity.ok(addStudentSection);
	}

	@GetMapping("/studentsections")
	public ResponseEntity<List<StudentSection>> getAllByStudent(@PathVariable Integer studentId) {
		return ResponseEntity.ok(this.studentSectionService.getStudentSectionsOfStudents(studentId));
	}

	

}