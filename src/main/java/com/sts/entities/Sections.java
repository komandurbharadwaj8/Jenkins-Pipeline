package com.sts.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Sections {
	
	@Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
	int sectionId;
	String sectionName;
	
//	@OneToMan
	//private List<Student> student;
	
	@OneToMany(mappedBy = "section", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Student> studentId = new ArrayList<>();
	
	@OneToMany(mappedBy = "section")
	private Set<StudentSection> students = new HashSet<>();

	
	
	public Sections() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Sections(int sectionId, String sectionName) {
		super();
		this.sectionId = sectionId;
		this.sectionName = sectionName;
	}




	public int getSectionId() {
		return sectionId;
	}


	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}


	public String getSectionName() {
		return sectionName;
	}


	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}



	public List<Student> getStudent() {
		return studentId;
	}
	
	public void setStudent(List<Student> student) {
		this.studentId = student;
	}

	
}
