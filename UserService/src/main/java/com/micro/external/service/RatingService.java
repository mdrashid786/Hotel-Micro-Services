package com.micro.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.micro.entities.Hotel;
import com.micro.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
	
	@GetMapping("hotels/{hotelId}") 
	Hotel getHotel(@PathVariable String hotelId);
	
	// create new Rating
	@PostMapping("/ratings")
	public Rating createRating(Rating values);
	
	//Update Rating
	@PutMapping("/{id}")
	public ResponseEntity<Rating> updateRating(Rating rating, @PathVariable String id);
		
}
