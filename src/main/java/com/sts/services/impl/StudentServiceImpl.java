package com.sts.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.entities.Student;
import com.sts.repos.StudentRepository;
import com.sts.services.StudentService;


@Service
public class StudentServiceImpl implements StudentService{
	
	
	@Autowired
	private StudentRepository studentRepository;


	@Override
	public Student addStudent(Student student) {
		
		Student savedStudent = this.studentRepository.save(student);
		return savedStudent;
	}

	@Override
	public Student getStudent(Integer studentId) {

		Student student = this.studentRepository.findById(studentId).get();
		return student;
	}

	@Override
	public List<Student> getStudents() {
		
		List<Student> students = this.studentRepository.findAll();
		return students;
	}

	@Override
	public void deleteStudent(int studentId) {
		
		Student student = this.studentRepository.findById(studentId).get();
		this.studentRepository.delete(student);
		
	}

	@Override
	public Student updateStudent(Student student, int studentId) {
		student.setId(studentId);
		Student updatedStudent = this.studentRepository.save(student);
		return updatedStudent;
	}

//	@Override
//	public List<Student> getStudent(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
