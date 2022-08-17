package com.example.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cts.client.AuthClient;
import com.example.cts.entity.AuthResponse;
import com.example.cts.entity.Movie;
import com.example.cts.exception.MovieEmptyException;
import com.example.cts.exception.MovieNotFoundException;
import com.example.cts.repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	AuthClient authClient;

	public Movie getMovieById(int id, String token) throws Exception {
		AuthResponse authResponse = authClient.getValidity(token);
		if (authResponse.isValid()) {
			Movie movie = movieRepository.findById(id).orElse(null);
			if (movie != null)
				return movie;
			else
				throw new MovieNotFoundException("Movie not found");
		} else {
			throw new Exception("Token Failed");
		}
	}

	public Movie addMovie(Movie movie, String token) throws Exception {
		AuthResponse authResponse = authClient.getValidity(token);
		if (authResponse.isValid()) {
			return movieRepository.save(movie);
		} else {
			throw new Exception("Token Failed");
		}
	}

	public List<Movie> getMovies(String token) throws Exception {
		AuthResponse authResponse = authClient.getValidity(token);
		if (authResponse.isValid()) {
			List<Movie> list = movieRepository.findAll();
			if (!list.isEmpty())
				return list;
			else
				throw new MovieEmptyException("There is no movies");
		} else {
			throw new Exception("Token Failed");
		}
	}
}
