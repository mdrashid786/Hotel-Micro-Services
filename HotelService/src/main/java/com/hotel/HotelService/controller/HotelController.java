package com.hotel.HotelService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.HotelService.bean.Hotel;
import com.hotel.HotelService.service.HotelService;

@RestController
@RequestMapping("hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels(){
		List<Hotel> hotelList=hotelService.getAllHotels();
		return ResponseEntity.ok(hotelList);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable Long id){
		Hotel getHotel=hotelService.getHotelById(id);
		return ResponseEntity.ok(getHotel);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Hotel> updateHotel( @RequestBody Hotel hotel, @PathVariable Long id){
		Hotel update=hotelService.updateHotel(hotel, id);
		return ResponseEntity.ok(update);
	}
	
	@PostMapping
	public ResponseEntity<Hotel> create( @RequestBody Hotel hotel){
		Hotel create=hotelService.create(hotel);
		return ResponseEntity.ok(create);
	}
	

}
