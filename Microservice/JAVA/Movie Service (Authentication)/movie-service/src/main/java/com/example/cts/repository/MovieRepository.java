package com.example.cts.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cts.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
