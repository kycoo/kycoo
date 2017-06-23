package com.kycoo.service;

import java.util.Date;
import java.util.List;

import com.kycoo.domain.City;
import com.kycoo.domain.Weather;

public interface WeatherService {
	Weather getTodayWeatherByCity(City city);
	
	List<Weather> getAfterWeekWeather(City city);
	
	List<Weather> getAfterHalfMonthWeather(City city);
	
	List<Weather> getAfter24HoursWeather(City city);
	
	void deleteDayWeatherByCity(City city);
	
	List<Weather> updateAfter24HourWeather(City city);
	List<Weather> updateAfterHalfMonthWeather(City city);

}
