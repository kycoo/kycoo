package com.kycoo.persistence;

import java.sql.Date;

import com.kycoo.domain.City;
import com.kycoo.domain.Weather;

public interface WeatherDao extends BaseDao<Weather, String> {
		public Weather findByDate(Date date);
		
	boolean addWeather();
	
	boolean getTodayWetherByCity(City city);
	
	boolean getWeekWeatherByCity(City city);
	
}
