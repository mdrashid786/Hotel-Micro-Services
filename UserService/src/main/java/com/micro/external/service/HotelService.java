package com.micro.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.micro.entities.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

	@GetMapping("hotels/{hotelId}") 
	Hotel getHotel(@PathVariable String hotelId);
}
