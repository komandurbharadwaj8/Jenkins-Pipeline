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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.entities.Address;
import com.sts.services.AddressService;

@RestController
@RequestMapping("/students/{studentId}")
@CrossOrigin("*")
public class AddressController {
	
	@Autowired
	 private AddressService addressService;
	
	 @PostMapping("/address")
	  public ResponseEntity<Address> addAddress(@PathVariable Integer studentId,@RequestBody Address address)
	  {
	   Address addedAddress = addressService.addAddress(address,studentId);
	   
	  return new ResponseEntity<Address>(addedAddress, HttpStatus.CREATED);
	  }
	 
	 @GetMapping("/address")
		public ResponseEntity<List<Address>> getAllByAddress(@PathVariable Integer studentId) {
			return ResponseEntity.ok(this.addressService.getAddressOfStudents(studentId));
		}

		@DeleteMapping("/{addressId}")
		public ResponseEntity<Map<String, Object>> deleteStudent(@PathVariable Integer addressId) {
			this.addressService.deleteAddress(addressId);
			return new ResponseEntity<>(Map.of("message", "address deleted successfully"), HttpStatus.OK);
		}
	 
//	  @GetMapping("/")
//	  public ResponseEntity<Address> getAddress(@PathVariable String street) {
//
//	  Address address = this.addressService.getAddressService(street);
//	  return new ResponseEntity<Address>(address, HttpStatus.OK);

	 }
	


