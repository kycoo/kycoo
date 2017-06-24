package com.kycoo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.kycoo.domain.City;
import com.kycoo.service.CityService;
import com.kycoo.service.WeatherService;
import com.kycoo.vo.DayWeatherVO;

@Controller
public class WeatherController {
	
	@Autowired
	WeatherService weatherService;
	@Autowired
	CityService cityService;
	private DayWeatherVO weatherVO;
	
	@GetMapping(value="/searchWeather", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getTodayWeatherByCityName(String cityName){
		City city = cityService.getCityByName(cityName);
		if(city != null){
			System.out.println(city.getCityName());
			weatherVO = new DayWeatherVO(weatherService.getTodayWeatherByCity(city));
			return JSON.toJSONString(weatherVO);
		}
		return "城市不唯一";
	}
	
	@GetMapping("/afterHalfMonth")
	@ResponseBody
	public String getAfterHalfMonthWeather(String cityname){
		
		City city = cityService.getCityByName(cityname);
		if(city != null){
			weatherService.getAfterHalfMonthWeather(city);
		}
		return "";
	}
	
	@GetMapping("/24HoursWeather")
	@ResponseBody
	public String get24HourWeather(String cityName){
		City city = cityService.getCityByName(cityName);
		if(city != null){
			weatherService.getAfter24HoursWeather(city);
		}
		return "";
	}
}
