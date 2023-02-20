package com.sts.entities;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity(name = "students")
@Table(name = "students")

public class Student {
    
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String city;
	private Integer fee;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Address> address = new HashSet<>();
     
	@JsonIgnore
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ProjectDetails> project = new HashSet<>();
    
	@JsonIgnore
	@ManyToOne
	private Sections section;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<StudentSection> sections = new HashSet<>();
	
	//@JsonIgnore
	//@OneToOne(  cascade = CascadeType.ALL)
	//private Fee fee1;
	@JsonIgnore
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Fee> Fee = new HashSet<>();
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(Integer id, String name, String city, Integer fee) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.fee = fee;
	}
	
	
	public Integer getFee() {
		return fee;
	}


	public void setFee(Integer fee) {
		this.fee = fee;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public Sections getSection() {
		return section;
	}
	
	public void setSection(Sections section) {
		this.section = section;
	}
	
	

}
