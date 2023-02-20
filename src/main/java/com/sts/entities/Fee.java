package com.sts.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.*;
import javax.persistence.Id;



@Entity
@Table(name = "Fee_Details")
public class Fee 
{
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feeId;
	private Integer totalfee;
	private Integer paidfee;
	private Integer remainingfee;
	
	@ManyToOne
	private Student student;
	
	public Fee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Fee(Integer feeId,Integer totalfee, Integer paidfee, Integer remainingfee) {
		super();
	    this.feeId =feeId;
		this.totalfee = totalfee;
		this.paidfee = paidfee;
		this.remainingfee = remainingfee;
	}

	

	public Integer getFeeId() {
		return feeId;
	}

	public void setFeeId(Integer feeId) {
		this.feeId = feeId;
	}

	public Integer getTotalfee() {
		return totalfee;
	}

	public void setTotalfee(Integer totalfee) {
		this.totalfee = totalfee;
	}

	public Integer getPaidfee() {
		return paidfee;
	}

	public void setPaidfee(Integer paidfee) {
		this.paidfee = paidfee;
	}

	public Integer getRemainingfee() {
		return remainingfee;
	}

	public void setRemainingfee(Integer remainingfee) {
		this.remainingfee = remainingfee;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		// TODO Auto-generated method stub
		this.student = student;
		
	}
}
