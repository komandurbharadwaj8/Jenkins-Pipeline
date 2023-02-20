package com.sts.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.entities.Sections;
import com.sts.entities.Student;
import com.sts.services.SectionService;


@RestController
@RequestMapping("/students/{studentId}")
@CrossOrigin("*")
public class SectionController {
	
	@Autowired
	private SectionService sectionService;
	
	@PostMapping("/section")
	public ResponseEntity<Sections> createSection(@PathVariable Integer studentId,@RequestBody Sections section)
	{
		Sections addedSection = sectionService.addSection(section,studentId);
		return new ResponseEntity<Sections>(addedSection, HttpStatus.CREATED);
		
	}
	
	//Get Section Of Student
	
		@GetMapping("/section")
		public ResponseEntity<Sections> getSectionOfStudent(@PathVariable Integer studentId) {
			return ResponseEntity.ok(this.sectionService.getSections(studentId));
		}
		
		//Get All Students in a Section
		
		@GetMapping("/section/{sectionId}")
		public ResponseEntity<List<Student>> getStudentsBySection(@PathVariable Integer sectionId) {
			return ResponseEntity.ok(this.sectionService.getStudentsOfSection(sectionId));
		}

}
