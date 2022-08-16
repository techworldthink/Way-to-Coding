package com.example.cts.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.cts.entity.Movie;
import com.example.cts.exception.MovieNotFoundException;

@FeignClient(url="${movie.url}" , name="movieservice")
public interface MovieClient {

	@GetMapping(value = "/getmovie/{id}")
	public Movie getMovieById(@PathVariable("id") int id) throws MovieNotFoundException;
}
