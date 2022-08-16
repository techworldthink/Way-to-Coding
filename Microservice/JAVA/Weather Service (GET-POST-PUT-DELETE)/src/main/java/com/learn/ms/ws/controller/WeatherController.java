package com.learn.ms.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ms.ws.entity.Weather;
import com.learn.ms.ws.service.WeatherService;
import com.learn.ms.ws.service.exception.StateNotFoundException;
import com.learn.ms.ws.service.exception.WeatherEmptyException;

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

	@GetMapping(value = "/getweathers")
	public List<Weather> getWeatherList() throws WeatherEmptyException {
		return weatherService.getWeatherList();
	}

	@DeleteMapping("/deleteweather/{id}")
	public Boolean deleteWeatherById(@PathVariable("id") int id) throws StateNotFoundException {
		return weatherService.deleteWeatherById(id);
	}

	@PutMapping("/updateweather/{id}")
	public Weather updateWeather(@PathVariable int id, @RequestBody Weather weather) throws StateNotFoundException {
		return weatherService.updateWeatherDetails(id, weather);
	}
}
