package com.ms.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ms.weather.entity.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {

}