package com.kycoo.utils.test;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.kycoo.domain.Weather;
import com.kycoo.utils.CommonUtil;
import com.kycoo.utils.WeatherUtil;

/**
 * Unit test for simple App.
 */
public class TestUtils {
	
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
		for (Weather w:WeatherUtil.list24HourWeatherByArea("成都", "")) {
			//System.out.println(w.getDate()+"=="+w.getWeather());
//			System.out.println(w.getDate());
		}
	}
	
	@Test
	public void testGetHalfMonthWeatherByArea(){
		for (Weather w:WeatherUtil.listHalfMonthweather("成都", "")) {
			//System.out.println(w.getDate()+"=="+w.getWeather());
			System.out.println(w.getDate());
		}
	}
	
	@Test
	public void convertDate(){
		int dayOfMonth = Calendar.DAY_OF_WEEK;
		System.out.println(dayOfMonth);
		Date date = CommonUtil.convetString2Date("20170622");
//		System.out.println(Calendar.getInstance().gett.getTimeInMillis());
		System.out.println(Calendar.getInstance().getTimeInMillis());
		
		System.out.println(date);
	}
	
}