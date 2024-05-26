package com.RatingService.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("user_ratings")
public class Rating {

	@Id
    private String id;

    private Long userId;

    private Long hotelId;

    private int rating;
    
    private String feedback;

	public Rating() {
		super();
	}

	public Rating(String id, Long userId, Long hotelId, int rating, String feedback) {
		super();
		this.id = id;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.feedback = feedback;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
    
    

}
