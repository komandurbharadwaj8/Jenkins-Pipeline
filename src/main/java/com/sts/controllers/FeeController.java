package com.sts.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.entities.Fee;
import com.sts.entities.Student;
import com.sts.services.FeeService;

@RestController
@RequestMapping("/students/{studentId}")
@CrossOrigin("*")
public class FeeController {

	@Autowired
	 private FeeService feeService;
	
	@PostMapping("/fee")
	  public ResponseEntity<Fee> addFee(@PathVariable Integer studentId,@RequestBody Fee fee)
	  {
	   Fee addedFee = feeService.addFee(fee,studentId);
	   
	  return new ResponseEntity<Fee>(addedFee, HttpStatus.CREATED);
	  }
	@GetMapping("/fee")
	public ResponseEntity<List<Fee>> getAllByFee(@PathVariable Integer studentId) {
		
		
		return ResponseEntity.ok(this.feeService.getFeeOfStudents(studentId));
	}

	@DeleteMapping("/{feeId}")
	public ResponseEntity<Map<String, Object>> deleteStudent(@PathVariable Integer studentId) {
		this.feeService.deleteFee(studentId);
		return new ResponseEntity<>(Map.of("message", "project deleted successfully"), HttpStatus.OK);
	}
	



}
