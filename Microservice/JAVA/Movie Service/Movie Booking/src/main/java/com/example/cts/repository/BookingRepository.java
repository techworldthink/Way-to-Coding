package com.example.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cts.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
