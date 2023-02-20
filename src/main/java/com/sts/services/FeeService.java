package com.sts.services;

import java.util.List;

import com.sts.entities.Fee;
import com.sts.entities.Student;


public interface FeeService {
	
	Fee addFee(Fee fee, Integer studentId);
    Fee getFee(Integer feeId);
	
	List<Fee> getFeeOfStudents(Integer studentId);
	void deleteFee(int studentId);

}