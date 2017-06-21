package com.kycoo.utils.test;


import java.util.List;

import org.junit.Test;

import com.kycoo.domain.Weather;
import com.kycoo.utils.WeatherUtil;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@Test
	public void testListThisWeekWeatherByIp(){
		List<Weather> weathers = WeatherUtil.listThisWeekWeatherByIp("182.149.161.97");
		for(Weather w:weathers){
			System.out.println(w.getDate()+"=="+w.getWeather());
		}
		System.out.println(weathers.size());
	}
	
	@Test
	public void testGet24HourWeatherByArea(){
		for (Weather w:WeatherUtil.get24HourWeatherByArea("³É¶¼", "")) {
			System.out.println(w.getDate()+"=="+w.getWeather());
		}
	}
	
}