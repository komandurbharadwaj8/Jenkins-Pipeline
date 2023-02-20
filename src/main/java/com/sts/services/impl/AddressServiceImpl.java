package com.sts.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.entities.Address;
import com.sts.entities.ProjectDetails;
import com.sts.entities.Student;
import com.sts.repos.AddressRepository;
import com.sts.repos.StudentRepository;
import com.sts.services.AddressService;


@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address getAddressService(String street) {
		
		Address address = this.addressRepository.findByStreet(street).get(0);
		return address;
	}

//	@Override
//	public Address addAddress(Address address) {
//		
//		Address savedAddress = this.addressRepository.save(address);
//		return savedAddress;
//	}

	@Override
	public Address addAddress(Address address, Integer studentId) {
		Student student = this.studentRepository.findById(studentId).get();

		address.setStudent(student);

		Address address1 = this.addressRepository.save(address);

		return address1;
	}

	@Override
	public List<Address> getAddressOfStudents(Integer studentId) {
		Student student = this.studentRepository.findById(studentId).get();

		return this.addressRepository.findByStudent(student);
	}

	@Override
	public void deleteAddress(int id) {
		// TODO Auto-generated method stub
		Address address = this.addressRepository.findById(id).get();
		this.studentRepository.deleteById(id);
		
	}

}
