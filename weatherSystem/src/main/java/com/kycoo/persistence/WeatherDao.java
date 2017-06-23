package com.kycoo.persistence;

import java.util.Date;
import java.util.List;

import com.kycoo.domain.City;
import com.kycoo.domain.Weather;

public interface WeatherDao extends BaseDao<Weather, Integer> {
	List<Weather> getWeather(City city,Date date,boolean isDay,int count);

}
