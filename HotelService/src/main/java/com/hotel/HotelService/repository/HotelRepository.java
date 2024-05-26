package com.hotel.HotelService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.HotelService.bean.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
