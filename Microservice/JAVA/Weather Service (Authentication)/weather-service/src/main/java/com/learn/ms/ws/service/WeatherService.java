package com.learn.ms.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learn.ms.ws.client.AuthClient;
import com.learn.ms.ws.entity.AuthResponse;
import com.learn.ms.ws.entity.Weather;
import com.learn.ms.ws.repository.WeatherRepository;
import com.learn.ms.ws.service.exception.StateNotFoundException;
import com.learn.ms.ws.service.exception.WeatherEmptyException;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository repository;

	@Autowired
	private AuthClient authClient;

	private void validateTocken(String token) throws Exception {
		AuthResponse authResponse = authClient.getValidity(token);
		if (!authResponse.isValid())
			throw new Exception("Token Failed");
	}

	public Weather addWeatherDetails(Weather weather, String token) throws Exception {
		validateTocken(token);
		repository.save(weather);
		return weather;
	}

	public Weather getWeatherById(int id, String token) throws Exception {
		validateTocken(token);
		Weather weather = repository.findById(id).orElse(null);
		if (weather != null)
			return weather;
		else
			throw new StateNotFoundException("State not found");
	}

	public List<Weather> getWeatherList(String token) throws Exception {
		validateTocken(token);
		List<Weather> list = repository.findAll();
		if (!list.isEmpty())
			return list;
		else
			throw new WeatherEmptyException("There is no weather details");
	}

	public Boolean deleteWeatherById(int id, String token) throws Exception {
		validateTocken(token);
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		} else {
			throw new StateNotFoundException("State not found");
		}
	}

	public Weather updateWeatherDetails(int id, Weather weather, String token) throws Exception {
		validateTocken(token);
		Weather weatherObj = repository.findById(id).orElse(null);
		if (weatherObj != null) {
			weatherObj.setHumidity(weather.getHumidity());
			weatherObj.setIndiaState(weather.getIndiaState());
			weatherObj.setTemperature(weather.getTemperature());
			weatherObj.setWind(weather.getWind());
			repository.save(weatherObj);
			return weatherObj;
		} else {
			throw new StateNotFoundException("State not found");
		}
	}

}
