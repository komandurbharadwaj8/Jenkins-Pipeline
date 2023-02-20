package com.sts.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.entities.Student;
import com.sts.entities.StudentSection;
import com.sts.repos.StudentRepository;
import com.sts.repos.StudentSectionRepo;
import com.sts.services.StudentSectionService;

@Service
public class StudentSectionServiceimpl implements StudentSectionService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentSectionRepo studentSectionRepo;

	@Override
	public StudentSection addStudentSection(StudentSection studentsection, Integer studentId) {
		Student student = this.studentRepository.findById(studentId).get();
		
		studentsection.setStudent(student);
		StudentSection studentsection1 = this.studentSectionRepo.save(studentsection);
		return studentsection1;
	}

	@Override
	public List<StudentSection> getStudentSectionsOfStudents(Integer studentId) {
		Student student = this.studentRepository.findById(studentId).get();
		
		return this.studentSectionRepo.findByStudent(student);
	}

}
