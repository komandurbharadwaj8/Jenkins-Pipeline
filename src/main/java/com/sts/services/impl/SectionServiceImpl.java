package com.sts.services.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sts.entities.Sections;
import com.sts.entities.Student;
import com.sts.repos.SectionRepository;
import com.sts.repos.StudentRepository;
import com.sts.services.SectionService;


@Service
public class SectionServiceImpl implements SectionService{
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Autowired
	private SectionRepository sectionRepository;



	@Override
	public Sections addSection(Sections section, Integer studentId) {
		Student student = this.studentRepository.findById(studentId).get();
		student.setSection(section);
		String name = student.getName();
		List<Student> s1 = this.studentRepository.findByName(name);
		section.setStudent(s1);

		Sections section1 = this.sectionRepository.save(section);

		return section1;
	}

	@Override
	public List<Student> getStudentsOfSection(Integer sectionId) {
		Sections section  = this.sectionRepository.findById(sectionId).get();
		List<Student> student1 = section.getStudent();
		
		return student1;
	}

	@Override
	public Sections getSections(Integer sectionsId) {
		Sections sections = this.sectionRepository.findById(sectionsId).get();

		return sections;
		
	}

	

}
