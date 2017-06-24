package com.kycoo.persistence.impl;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kycoo.domain.City;
import com.kycoo.domain.Weather;
import com.kycoo.persistence.WeatherDao;

@Repository
public class WeatherDaoDbImpl 
extends BaseDaoHibernateAdapter<Weather, Integer>
implements WeatherDao
{

	@Override
	public List<Weather> getWeather(City city, Date date, boolean isDay, int count) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Weather as w where w.isDay = ? and w.date >= ? and w.city = ? order by w.date",Weather.class)
				.setParameter(0, isDay)
				.setParameter(1, date)
				.setParameter(2, city)
				.setMaxResults(count)
				.getResultList();
	}

	
	


	
}
