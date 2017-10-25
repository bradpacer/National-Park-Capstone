package com.techelevator.npgeek.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Weather;

@Component
public interface WeatherDao {

	List<Weather> getWeatherForPark(String code);
	

}
