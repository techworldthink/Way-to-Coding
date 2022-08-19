package com.ms.weather.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.weather.entity.Weather;
import com.ms.weather.exceptions.StateNotFoundException;
import com.ms.weather.exceptions.WeatherEmptyException;
import com.ms.weather.service.WeatherService;


@RestController
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@PostMapping(value = "/addweather")
	public Weather addWeather(@RequestBody Weather weather) {
		return weatherService.addWeatherDetails(weather);
	}

	@GetMapping(value = "/getweather/{id}")
	public Weather getWeatherById(@PathVariable("id") int id) throws StateNotFoundException {
		return weatherService.getWeatherById(id);
	}
	
	@GetMapping(value = "/")
	public List<Weather> getWeatherList() throws WeatherEmptyException {
		return weatherService.getWeatherList();
	}
}
