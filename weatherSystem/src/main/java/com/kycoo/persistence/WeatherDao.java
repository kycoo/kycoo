package com.kycoo.persistence;

import java.sql.Date;

import com.kycoo.domain.Weather;

public interface WeatherDao extends BaseDao<Weather, String> {
		public Weather findByDate(Date date);
		
}
