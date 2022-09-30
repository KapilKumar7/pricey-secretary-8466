package com.cabBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabBooking.models.TripBooking;

@Repository
public interface TripBookingDao extends JpaRepository<TripBooking, Integer>{

}
