package com.kycoo.service.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kycoo.domain.City;
import com.kycoo.domain.Weather;
import com.kycoo.service.WeatherService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:app.xml"})
public class WeatherServiceTest {
	private City city;
	
	@Before
	public void init(){
		city = new City();
		city.setId("101270101");
//		city.setCityName("³É¶¼");
	}
	
	@Autowired
	WeatherService service;
	
	@Test
	public void testGetTodayWetherByCity(){
		
		Weather w = service.getTodayWeatherByCity(city);
		Assert.assertNotNull(w);
		System.out.println(w.getDate());
	}
	
	@Test
	public void testGetAfterHalfMonthWeather(){
		List<Weather> ws = service.getAfterHalfMonthWeather(city);
		Assert.assertNotNull(ws);
		for(Weather w:ws){
			System.out.println(w.getDate());
		}
	}
	
	@Test
	public void testGetAfterWeekWeather(){
		List<Weather> ws = service.getAfterWeekWeather(city);
		Assert.assertNotNull(ws);
		for(Weather w:ws){
			System.out.println(w.getDate());
		}
	}
	
	@Test
	public void testGetAfter24HoursWeather(){
		List<Weather> ws = service.getAfter24HoursWeather(city);
		Assert.assertNotNull(ws);
		System.out.println(ws.size());
		for(Weather w:ws){
			System.out.println(w.getDate());
		}
	}
}
