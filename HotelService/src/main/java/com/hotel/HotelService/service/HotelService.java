package com.hotel.HotelService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.HotelService.bean.Hotel;
import com.hotel.HotelService.repository.HotelRepository;

@Service
public class HotelService {
	
	@Autowired 
	private HotelRepository hotelRepository;

	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	public Hotel updateHotel(Hotel hotel, Long id) {
		Optional<Hotel> existingHotel=hotelRepository.findById(id);
		Hotel updateNew=null;
		if (existingHotel!=null) {
			Hotel update=existingHotel.get();
			update.setName(hotel.getName());
			update.setAbout(hotel.getAbout());
			update.setLocation(hotel.getLocation());
			updateNew=hotelRepository.save(update);
			
		}
		return updateNew;
		
	}

	public Hotel create(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	public Hotel getHotelById(Long id) {
		Optional<Hotel> hotel= hotelRepository.findById(id);
		return hotel.get();
	}

}
