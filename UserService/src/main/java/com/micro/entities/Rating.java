package com.micro.entities;

import lombok.Builder;

@Builder
public class Rating {

	
    private String id;

    private String userId;

    private String hotelId;

    private int rating;
    
    private String feedback;
    
    private Hotel hotel;
    
    
    
	public Rating() {
		super();
	}
	
	
	
	public Rating(String id, String userId, String hotelId, int rating, String feedback, Hotel hotel) {
		super();
		this.id = id;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.feedback = feedback;
		this.hotel = hotel;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
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

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
    
    

}
