package com.kycoo.service;


import com.kycoo.domain.City;

public interface CityService {
	City getCityById(String id);//输入城市名查找
	
	City getCityByName(String name);
}
