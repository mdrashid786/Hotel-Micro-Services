package com.RatingService.service;

import java.util.List;

import com.RatingService.entities.Rating;

public interface RatingService {
	
	// create 
	Rating create(Rating rating);
	
	// update rating
	Rating updateRating(Rating rating, String id);
	
	// get all rating
    List<Rating> getAllRatings();
    
    // get rating by hotel id
    List<Rating> getRatingByHotelId(Long hotelid);
    
    // get rating by user id
    List<Rating> getRatingByUserId(Long userId);
    
    
	

}
