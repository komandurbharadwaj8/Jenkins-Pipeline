package com.sts.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.entities.Address;
import com.sts.entities.Student;


public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	
	List<Address> findByStreet(String street);
	
	List<Address> findByCity(String city);

	List<Address> findByStudent(Student student);
	
	
	

}
