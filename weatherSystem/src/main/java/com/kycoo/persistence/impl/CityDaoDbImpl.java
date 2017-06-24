package com.kycoo.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kycoo.domain.City;
import com.kycoo.persistence.CityDao;

@Repository
public class CityDaoDbImpl
extends BaseDaoHibernateAdapter<City,String>
implements CityDao {

	@Override
	public List<City> findByName(String name) {
		
		return sessionFactory.getCurrentSession()
				.createQuery("from City as c where c.cityName = ?",City.class)
				.setParameter(0,name)
				.getResultList();
	}

}
