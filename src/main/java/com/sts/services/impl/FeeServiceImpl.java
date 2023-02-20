package com.sts.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.entities.Fee;
import com.sts.entities.ProjectDetails;
import com.sts.entities.Student;
import com.sts.repos.FeeRepository;
import com.sts.repos.StudentRepository;
import com.sts.services.FeeService;


@Service

public class FeeServiceImpl implements FeeService
{

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private FeeRepository feeRepository;
	
	@Override
	public Fee addFee(Fee fee, Integer studentId) {
		// TODO Auto-generated method stub
		Student student = this.studentRepository.findById(studentId).get();

		fee.setStudent(student);

		Fee fee1 = this.feeRepository.save(fee);

		return fee1;
		
	}

	@Override
	public Fee getFee(Integer studentId) {
		// TODO Auto-generated method stub
		Fee fee = this.feeRepository.findById(studentId).get();
		return fee;
	}

	@Override
	public List<Fee> getFeeOfStudents(Integer studentId) {
		// TODO Auto-generated method stub
		Student student = this.studentRepository.findById(studentId).get();

		return this.feeRepository.findByStudent(student);
	}

	@Override
	public void deleteFee(int studentId) {
		// TODO Auto-generated method stub
		Student student = this.studentRepository.findById(studentId).get();
		this.feeRepository.deleteById(studentId);
	}


}
