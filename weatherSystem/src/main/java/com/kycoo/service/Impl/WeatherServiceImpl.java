package com.kycoo.service.Impl;

import com.kycoo.domain.Weather;
import com.kycoo.persistence.WeatherDao;
import com.kycoo.service.WeatherService;

public class WeatherServiceImpl implements WeatherService {
	
	private WeatherDao weatherDao;
	@Override
	public String getWeather(Weather weather) {
		 
		return  weatherDao.save(weather);
	}

}
