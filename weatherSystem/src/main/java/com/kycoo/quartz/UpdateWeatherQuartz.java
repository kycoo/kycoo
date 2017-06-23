package com.kycoo.quartz;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.kycoo.service.CityService;

public class UpdateWeatherQuartz {

	@Autowired
	CityService cityService;
	
    public void updateWeather()  {  
    		new Date().setTime(1000);
        long ms = System.currentTimeMillis();  
        cityService.getCityByName("成都");
    }  
	
}
