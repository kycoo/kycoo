package com.kycoo.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.util.JsonExpectationsHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.kycoo.domain.City;
import com.kycoo.domain.Weather;
import com.kycoo.service.CityService;
import com.kycoo.service.WeatherService;
import com.kycoo.vo.DayWeatherVO;
import com.kycoo.vo.HourWeatherVO;

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
		System.out.println(cityName);
		City city = cityService.getCityByName(cityName);
		if(city != null){
			System.out.println(city.getCityName());
			weatherVO = new DayWeatherVO(weatherService.getTodayWeatherByCity(city));
			return JSON.toJSONString(weatherVO);
		}
		return "���в�Ψһ";
	}
	
	@GetMapping("/afterHalfMonth")
	@ResponseBody
	public String getAfterHalfMonthWeather(String cityName){
		System.out.println(cityName);
		City city = cityService.getCityByName(cityName);
		if(city != null){
			weatherService.getAfterHalfMonthWeather(city);
		}
		return "";
	}
	
	@GetMapping("/24HoursWeather")
	@ResponseBody
	public String get24HourWeather(String cityName){
		System.out.println(cityName);
		List<HourWeatherVO> hourWeatherVOs = new ArrayList<>();
		City city = cityService.getCityByName(cityName);
		if(city != null){
			for(Weather w:weatherService.getAfter24HoursWeather(city)){
				hourWeatherVOs.add(new HourWeatherVO(w));
			}
			return JSON.toJSONString(hourWeatherVOs);
		}
		return "";
	}
}
