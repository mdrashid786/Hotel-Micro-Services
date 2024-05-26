package com.hotel.HotelService.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("staffs")
public class HotelStaffController {
	
	@GetMapping
	public ResponseEntity<List<String>> getAllStaffs() {
		List<String> staffList=new ArrayList<String>();
		staffList.add("Jatin");
		staffList.add("neeraj");
		staffList.add("mohit");
		staffList.add("shakil");
		return ResponseEntity.ok(staffList);
		
	}

}
