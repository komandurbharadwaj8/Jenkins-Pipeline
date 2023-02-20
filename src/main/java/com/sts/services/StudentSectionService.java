package com.sts.services;

import java.util.List;

import com.sts.entities.StudentSection;

public interface StudentSectionService {
	
	StudentSection addStudentSection(StudentSection studentsection,Integer studentId);
	
	List<StudentSection> getStudentSectionsOfStudents(Integer studentId);

}
