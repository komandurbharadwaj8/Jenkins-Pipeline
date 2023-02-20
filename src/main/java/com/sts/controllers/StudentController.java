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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.entities.Student;
import com.sts.services.StudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/")
	public ResponseEntity<Student> createStudent(@RequestBody Student student)
	{
		Student addedStudent = studentService.addStudent(student);
		return new ResponseEntity<Student>(addedStudent, HttpStatus.CREATED);
		
	}
	
	//get all
	
	@GetMapping("/")
	public ResponseEntity<List<Student>> getStudent() {
		return new ResponseEntity<List<Student>>(studentService.getStudents(), HttpStatus.OK);
	}
	
	// get -single student
	
		@GetMapping("/{studentId}")
		public ResponseEntity<Student> getStudent(@PathVariable Integer studentId) {

			Student student = this.studentService.getStudent(studentId);
			return new ResponseEntity<Student>(student, HttpStatus.OK);

		}
		
		// delete

		@DeleteMapping("/{studentId}")
		public ResponseEntity<Map<String, Object>> deleteStudent(@PathVariable Integer studentId) {
			this.studentService.deleteStudent(studentId);
			return new ResponseEntity<>(Map.of("message", "student deleted successfully"), HttpStatus.OK);
		}

		// update

		@PutMapping("/{studentId}")
		public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Integer studentId) {
			Student updateStudent = this.studentService.updateStudent(student, studentId);
			return ResponseEntity.ok(updateStudent);

		}

		
		
		
}
