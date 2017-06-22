package com.kycoo.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kycoo.domain.City;
import com.kycoo.domain.Weather;
import com.kycoo.persistence.WeatherDao;
import com.kycoo.service.WeatherService;
import com.kycoo.utils.CommonUtil;

@Service
@Transactional
public class WeatherServiceImpl implements WeatherService {
	
	@Autowired
	private WeatherDao weatherDao;

	@Override
	public Weather getTodayWeatherByCity(City city) {
		return weatherDao.getWeather(city, 
				CommonUtil.getTodayStartDate(),
				false,
				1).get(0);
	}

	@Override
	public List<Weather> getAfterWeekWeather(City city) {
		
		return weatherDao.getWeather(city, 
				CommonUtil.getTodayStartDate(), 
				true, 7);
	}

	@Override
	public List<Weather> getAfterHalfMonthWeather(City city) {
		return weatherDao.getWeather(city, 
				CommonUtil.getTodayStartDate(), 
				true, 15);
	}

	@Override
	public List<Weather> getAfter24HoursWeather(City city) {
		return weatherDao.getWeather(city, 
				CommonUtil.getTodayStartDate(), 
				false, 24);
	}
	
	

}
