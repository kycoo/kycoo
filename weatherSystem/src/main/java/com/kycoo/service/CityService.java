package com.kycoo.service;


import com.kycoo.domain.City;

public interface CityService {
	City getCityById(String id);//�������������
	
	City getCityByName(String name);
}
