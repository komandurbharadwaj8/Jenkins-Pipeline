package com.sts.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
	@Table(name = "student_in_section")
	public class StudentSection {
		
		@Id
		//@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int studentSectionId;
		
		private String session;
		
		
		@ManyToOne
		@JoinColumn(name="student_id")
		private Student student;
		
		
		@ManyToOne
		@JoinColumn(name="section_id")
		private Sections section;
		

		

		public StudentSection() {
			super();
			
		}


		public StudentSection(int studentSectionId, String session, Student student) {
		super();
		this.studentSectionId = studentSectionId;
		this.session = session;
		this.student = student;
	}


		public int getStudentSectionId() {
			return studentSectionId;
		}


		public void setStudentSectionId(int studentSectionId) {
			this.studentSectionId = studentSectionId;
		}


		public String getSession() {
			return session;
		}


		public void setSession(String session) {
			this.session = session;
		}


		public Student getStudent() {
			return student;
		}


		public void setStudent(Student student) {
			this.student = student;
			
		}


}
