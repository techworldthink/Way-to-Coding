package com.example.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.cts.entity.Movie;
import com.example.cts.exception.MovieEmptyException;
import com.example.cts.exception.MovieNotFoundException;
import com.example.cts.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	MovieService movieService;
	
	@GetMapping(value = "/getmovie/{id}")
	public Movie getMovieById(@PathVariable("id") int id , @RequestHeader("Authorization") final String token) throws Exception {
		return movieService.getMovieById(id,token);
	}
	
	@PostMapping(value = "/addmovie")
	public Movie addMovie( @RequestBody Movie movie , @RequestHeader("Authorization") final String token) throws Exception {
		return movieService.addMovie(movie,token);
	}

	@GetMapping(value = "/getmovies")
	public List<Movie> getMovies(@RequestHeader("Authorization") final String token) throws Exception{
		return movieService.getMovies(token);
	}
}
