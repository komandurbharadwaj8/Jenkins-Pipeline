package com.sts.services;

import java.util.List;

import com.sts.entities.Address;

public interface AddressService {
	
	public Address getAddressService(String street);
	  public Address addAddress(Address address,Integer studentId);
	  
	  List<Address> getAddressOfStudents(Integer studentId);

	  void deleteAddress(int projectId);


}
