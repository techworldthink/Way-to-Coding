package com.example.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cts.entity.Movie;
import com.example.cts.exception.MovieEmptyException;
import com.example.cts.exception.MovieNotFoundException;
import com.example.cts.repository.MovieRepository;

@Service
public class MovieService {
    @Autowired
	MovieRepository movieRepository;
    
    
    public Movie getMovieById( int id) throws MovieNotFoundException {
    	Movie movie = movieRepository.findById(id).orElse(null);
    	if(movie!=null)
    		return movie;
    	else
    		throw new MovieNotFoundException("Movie not found");
    }
    public Movie addMovie(Movie movie) {
    	return movieRepository.save(movie);
    }
    
    public List<Movie> getMovies() throws MovieEmptyException{
    	List<Movie> list = movieRepository.findAll();
    	if(!list.isEmpty())
    		return list;
    	else
    		throw new MovieEmptyException("There is no movies");
    }
}
