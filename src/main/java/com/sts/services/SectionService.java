package com.sts.services;

import java.util.List;

import com.sts.entities.Sections;
import com.sts.entities.Student;


public interface SectionService {
	


	Sections addSection(Sections section, Integer studentId);
	
	
	List<Student> getStudentsOfSection(Integer sectionId);
	
	Sections getSections(Integer sectionsId);

}
