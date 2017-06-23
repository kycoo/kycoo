package com.kycoo.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kycoo.domain.City;
import com.kycoo.persistence.CityDao;
import com.kycoo.service.CityService;
import com.kycoo.utils.WeatherUtil;

@Service
@Transactional
public class CityServiceImpl implements CityService{
	@Autowired
	private	CityDao cityDao;

	@Override
	public City getCityById(String id) {
		return cityDao.findById(id);
	}

	@Override
	public City getCityByName(String name) {
		List<City> cities = cityDao.findByName(name);
		City city = null;
		if(cities.size() == 1){
			city = cities.get(0);
		}else if(cities.size() == 0){
			List<City> cs = WeatherUtil.getCityByName(name);
			for(City c : cs){
				if(cityDao.findById(c.getId()) == null){
					c.setProvince(null);
					cityDao.save(c);
					if(c.getCityName().equals(name)){
						city = c;
					}
				}
			}
		}
		
		return city;
	}
	

}
