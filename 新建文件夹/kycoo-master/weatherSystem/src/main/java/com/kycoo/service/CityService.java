package com.kycoo.service;


import java.util.List;

import com.kycoo.domain.City;

public interface CityService {
	City getCityById(String id);//�������������
	
	City getCityByName(String name);
	
	List<City> getAllCity();
}
