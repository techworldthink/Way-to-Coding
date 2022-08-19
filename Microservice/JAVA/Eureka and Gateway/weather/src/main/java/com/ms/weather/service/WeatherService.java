package com.ms.weather.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.weather.entity.Weather;
import com.ms.weather.exceptions.StateNotFoundException;
import com.ms.weather.exceptions.WeatherEmptyException;
import com.ms.weather.repository.WeatherRepository;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository repository;

	public Weather addWeatherDetails(Weather weather) {
		repository.save(weather);
		return weather;
	}

	public Weather getWeatherById(int id) throws StateNotFoundException {
		Weather weather = repository.findById(id).orElse(null);
		if (weather != null)
			return weather;
		else
			throw new StateNotFoundException("State not found");
	}

	public List<Weather> getWeatherList() throws WeatherEmptyException {
		List<Weather> list = repository.findAll();
		if (!list.isEmpty())
			return list;
		else
			throw new WeatherEmptyException("There is no weather details");
	}

}