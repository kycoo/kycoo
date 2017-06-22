package com.kycoo.service.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kycoo.domain.City;
import com.kycoo.persistence.CityDao;
import com.kycoo.service.CityService;

@Service
@Transactional
public class CityServiceImpl implements CityService{
	@Autowired
	private	CityDao cityDao;

	@Override
	public City getCityById(String id) {
		return cityDao.findById(id);
	}
	

}
