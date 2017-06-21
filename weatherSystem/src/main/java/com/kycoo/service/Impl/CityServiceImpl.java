package com.kycoo.service.Impl;

import com.kycoo.domain.City;
import com.kycoo.persistence.CityDao;
import com.kycoo.service.CityService;

public class CityServiceImpl implements CityService{
	
	private	CityDao cityDao;
	@Override
	public String getCity(City city) {
	
		 return cityDao.save(city);
	}

}
