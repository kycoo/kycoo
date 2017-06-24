package com.kycoo.utils.test;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.kycoo.domain.City;
import com.kycoo.domain.Weather;
import com.kycoo.utils.CommonUtil;
import com.kycoo.utils.WeatherUtil;

/**
 * Unit test for simple App.
 */
public class UtilsTest {
	
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
		for (Weather w:WeatherUtil.list24HourWeatherByArea("�ɶ�", "")) {
			//System.out.println(w.getDate()+"=="+w.getWeather());
//			System.out.println(w.getDate());
		}
	}
	
	@Test
	public void testGetHalfMonthWeatherByArea(){
		for (Weather w:WeatherUtil.listHalfMonthweather("�ɶ�", "")) {
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
	
	@Test
	public void getCityByName(){
		List<City> cities = WeatherUtil.getCityByName("�ɶ�");
		for(int i=0;i<cities.size();i++){
			
			System.out.println(cities.get(i).getId());
			System.out.println(cities.get(i).getCityName());
		}
		System.out.println(cities.size());
//		System.out.println(city.getId());
		
	}
}