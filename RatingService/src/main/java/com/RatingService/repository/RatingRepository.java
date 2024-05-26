package com.RatingService.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.RatingService.entities.Rating;

public interface RatingRepository extends MongoRepository<Rating, String>{
	
	List<Rating> findByUserId(Long userId);
	
	List<Rating> findByHotelId(Long hotelId);

}
