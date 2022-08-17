package com.learn.ms.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
	public Weather addWeather(@RequestBody Weather weather, @RequestHeader("Authorization") final String token)
			throws Exception {
		return weatherService.addWeatherDetails(weather, token);
	}

	@GetMapping(value = "/getweather/{id}")
	public Weather getWeatherById(@PathVariable("id") int id, @RequestHeader("Authorization") final String token)
			throws StateNotFoundException, Exception {
		return weatherService.getWeatherById(id, token);
	}

	@GetMapping(value = "/getweathers")
	public List<Weather> getWeatherList(@RequestHeader("Authorization") final String token)
			throws WeatherEmptyException, Exception {
		return weatherService.getWeatherList(token);
	}

	@DeleteMapping("/deleteweather/{id}")
	public Boolean deleteWeatherById(@PathVariable("id") int id, @RequestHeader("Authorization") final String token)
			throws StateNotFoundException, Exception {
		return weatherService.deleteWeatherById(id, token);
	}

	@PutMapping("/updateweather/{id}")
	public Weather updateWeather(@PathVariable int id, @RequestBody Weather weather,
			@RequestHeader("Authorization") final String token) throws StateNotFoundException, Exception {
		return weatherService.updateWeatherDetails(id, weather, token);
	}
}
