package com.sts.services;

import java.util.List;

import com.sts.entities.Student;

public interface StudentService {
	
	Student addStudent(Student student);
	
	Student getStudent(Integer studentId);
	
	List<Student> getStudents();
	
	//List<Student> getStudent(String name);
	
	void deleteStudent(int studentId);
	
	Student updateStudent(Student student, int studentId);

}
