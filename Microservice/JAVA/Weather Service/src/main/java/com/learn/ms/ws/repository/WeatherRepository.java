package com.learn.ms.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.learn.ms.ws.entity.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer>{

}
