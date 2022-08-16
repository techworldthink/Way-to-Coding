package com.example.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cts.entity.Booking;
import com.example.cts.exception.MovieNotFoundException;
import com.example.cts.service.BookingService;

@RestController
public class BookingController {
	@Autowired
	BookingService bookingService;

	@PostMapping(value = "/makebooking")
	public Booking makeBooking(@RequestBody Booking booking) throws MovieNotFoundException {
		return bookingService.makeBooking(booking);
	}
	
}
