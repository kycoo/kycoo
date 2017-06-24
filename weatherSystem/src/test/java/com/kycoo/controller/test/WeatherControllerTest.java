package com.kycoo.controller.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.kycoo.domain.City;
import com.kycoo.domain.Weather;
import com.kycoo.service.CityService;
import com.kycoo.service.WeatherService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:app.xml"})
public class WeatherControllerTest {
	@Autowired
	CityService cityService;
	@Autowired
	WeatherService weatherService;
	
	private String cityName;
	private String result;
	
	@Before
	public void init(){
		cityName = "成都";
	}
	@After
	public void result(){
		System.out.println(result);
	}
	
	@Test
	public void getWeatherByCityName(){
		City city = cityService.getCityByName(cityName);
		
		if(city != null){
			System.out.println(city.getCityName());
			result = JSON.toJSONString(weatherService.getTodayWeatherByCity(city));
		}
	}
	
	@Test
	public void testGetAfterHalfMonthWeather(){
		City city = cityService.getCityByName(cityName);
		if(city != null){
			List<Weather> weathers = weatherService.getAfterHalfMonthWeather(city);
			for(Weather w:weathers){
				System.out.println(w.getDate() + "==" + w.getWeather());
			}
		}
	}
	
	@Test
	public void testGet24HourWeather(){
		cityName = "����";
		City city = cityService.getCityByName(cityName);
		if(city != null){
			List<Weather> weathers = weatherService.getAfter24HoursWeather(city);
			for(Weather w:weathers){
				System.out.println(w.getDate() + "==" +w.getWeather());
			}
		}
	}
}
