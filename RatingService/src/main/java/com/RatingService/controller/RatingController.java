package com.RatingService.controller;

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

import com.RatingService.entities.Rating;
import com.RatingService.service.RatingService;

@RestController
@RequestMapping("ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings() {
		List<Rating> ratingList=ratingService.getAllRatings();
		return  ResponseEntity.ok(ratingList);
	}
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		Rating newRating=ratingService.create(rating);
		return ResponseEntity.ok(newRating)	;
				
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Rating> updateRating(@RequestBody Rating rating, @PathVariable String id) {
		Rating updateNew=ratingService.updateRating(rating, id);
		return ResponseEntity.ok(updateNew);
				
	}
	
	@GetMapping("users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable Long userId){
		List<Rating> getRatingByUserId=ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(getRatingByUserId);
	}
	
	@GetMapping("hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable Long hotelId){
		List<Rating> getRatingByHotelId=ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(getRatingByHotelId);
	}
	

}
