package com.kycoo.persistence.impl;

import org.springframework.stereotype.Repository;

import com.kycoo.domain.City;
import com.kycoo.persistence.CityDao;

@Repository
public class CityDaoDbImpl
extends BaseDaoHibernateAdapter<City,String>
implements CityDao {

}
