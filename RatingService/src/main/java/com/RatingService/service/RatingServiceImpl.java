package com.RatingService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RatingService.entities.Rating;
import com.RatingService.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating create(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByHotelId(Long hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

	@Override
	public List<Rating> getRatingByUserId(Long userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public Rating updateRating(Rating rating, String id) {
		Optional<Rating> existingRating=ratingRepository.findById(id);
		Rating updateNew=null;
		if (existingRating.isPresent()) {
			updateNew=existingRating.get();
			updateNew.setRating(rating.getRating());
			updateNew.setFeedback(rating.getFeedback());
			updateNew.setHotelId(rating.getHotelId());
			updateNew.setUserId(rating.getUserId());
		}
		return updateNew;
	}

}
