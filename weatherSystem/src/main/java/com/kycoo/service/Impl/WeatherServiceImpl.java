package com.kycoo.service.Impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kycoo.domain.City;
import com.kycoo.domain.Weather;
import com.kycoo.persistence.WeatherDao;
import com.kycoo.service.WeatherService;
import com.kycoo.utils.CommonUtil;
import com.kycoo.utils.WeatherUtil;

@Service
@Transactional
public class WeatherServiceImpl implements WeatherService {
	
	@Autowired
	private WeatherDao weatherDao;

	@Override
	public Weather getTodayWeatherByCity(City city) {
		List<Weather> weathers =  weatherDao.getWeather(city, 
				CommonUtil.getTodayStartDate(),
				true,
				1);
		if (weathers.size() == 0) {
			weathers = updateAfterHalfMonthWeather(city);
		}
		
		return weathers.get(0);
	}

	@Override
	public List<Weather> getAfterWeekWeather(City city) {
		List<Weather> weathers= weatherDao.getWeather(city, 
					CommonUtil.getTodayStartDate(), 
					true, 7);
		if(weathers.size() != 7){
			weathers = updateAfterHalfMonthWeather(city);
			for(int i = 7 ; i < 15 ; i++){
				weathers.remove(i);
			}
		}
		return weathers;
	}

	@Override
	public List<Weather> getAfterHalfMonthWeather(City city) {
		
		List<Weather> weathers = weatherDao.getWeather(city, 
				CommonUtil.getTodayStartDate(), 
				true, 15);
		if(weathers.size() != 15){
			updateAfterHalfMonthWeather(city);
		}
		return weathers;
	}

	/**
	 * 由于api的原因只获取了之后的23个小时
	 */
	@Override
	public List<Weather> getAfter24HoursWeather(City city) {
		List<Weather> weathers = weatherDao.getWeather(city, 
				CommonUtil.formatDate(new Date()), 
				false, 23);
		//没有足够的数据(暂未更新)
		if (weathers.size() < 23) {
			System.out.println("数据不够");
			return updateAfter24HourWeather(city);
		}
		return weathers;
	}

	@Override
	public List<Weather> updateAfterHalfMonthWeather(City city) {
		deleteDayWeatherByCity(city);
		List<Weather> weathers = WeatherUtil.listHalfMonthweather(city.getCityName(), city.getId());
		for(Weather w:weathers){
			weatherDao.save(w);
		}
		return weathers;
	}


	@Override
	public void deleteDayWeatherByCity(City city) {
		List<Weather> weathers = weatherDao.getWeather(city, 
				CommonUtil.getTodayStartDate(), 
				true,
				15);
		for(Weather w:weathers){
			weatherDao.delete(w);;
		}
		
	}

	@Override
	public List<Weather> updateAfter24HourWeather(City city) {
		List<Weather> weathers = weatherDao.getWeather(city,
				CommonUtil.getCurentHour(),
				false, 24);
		for(Weather w:weathers){
			weatherDao.delete(w);
		}
		weathers = WeatherUtil.list24HourWeatherByArea(city.getCityName(), city.getId());
		for(Weather w:weathers){
			weatherDao.save(w);
		}
		return weathers;
	}
	
	

}
