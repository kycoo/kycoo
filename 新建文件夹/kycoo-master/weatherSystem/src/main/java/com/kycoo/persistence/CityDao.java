package com.kycoo.persistence;

import java.util.List;

import com.kycoo.domain.City;

public interface CityDao extends BaseDao<City, String> {

	List<City> findByName(String name);
	
}
