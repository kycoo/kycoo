package com.kycoo.quartz;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kycoo.domain.City;
import com.kycoo.service.CityService;
import com.kycoo.service.WeatherService;

public class UpdateWeatherQuartz {

	@Autowired
	CityService cityService;
	@Autowired
	WeatherService weatherService;
	
    public void updateWeather()  {  
    		new Date().setTime(1000);
        List<City> cities = cityService.getAllCity();
        for(City c:cities){
        	weatherService.updateAfterHalfMonthWeather(c);
        }
        System.out.println("更新数据");
    }  
	
}
