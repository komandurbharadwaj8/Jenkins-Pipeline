package com.sts.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.entities.Fee;

import com.sts.entities.Student;

public interface FeeRepository extends JpaRepository<Fee, Integer>{

	List<Fee> findByFeeId(String FeeId );

	List<Fee> findByStudent(Student student);
}
