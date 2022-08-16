package com.example.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cts.client.MovieClient;
import com.example.cts.entity.Booking;
import com.example.cts.entity.Movie;
import com.example.cts.exception.MovieNotFoundException;
import com.example.cts.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	MovieClient movieClient;
	
	public Booking makeBooking( Booking booking) throws MovieNotFoundException {
		Movie movie = movieClient.getMovieById(booking.getMovieId());
		int price = movie.getTicketPrice()*booking.getNoOfTickets();
		booking.setPrice(price);
		booking = bookingRepository.save(booking);
		return booking;
	}

}




