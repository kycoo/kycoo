package com.kycoo.service.Impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
		return weatherDao.getWeather(city, 
				CommonUtil.getTodayStartDate(),
				true,
				1).get(0);
	}

	@Override
	public List<Weather> getAfterWeekWeather(City city) {
		
		return weatherDao.getWeather(city, 
				CommonUtil.getTodayStartDate(), 
				true, 7);
	}

	@Override
	public List<Weather> getAfterHalfMonthWeather(City city) {
		return weatherDao.getWeather(city, 
				CommonUtil.getTodayStartDate(), 
				true, 15);
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
			List<Weather> ws = WeatherUtil.list24HourWeatherByArea(city.getCityName(), city.getId());
			Collections.sort(ws);
			Weather w1 =  null,w2=null;
			int j = 0;
			for(int i=0;i<weathers.size();i++){
				w1 = weathers.get(j++);
				w2 = ws.get(i);
				if(w2.getDate().before(w1.getDate())){
//					System.out.println(ws.get(i).getDate());
//					System.out.println(w.getDate());
					j--;
					continue;
				}else if (w2.equals(w1.getDate())) {
					w2.setHighTemp(w1.getHighTemp());
					w2.setWeather(w1.getWeather());
					w2.setUpDateTime(w1.getUpDateTime());
					w2.setLowTemp(w1.getLowTemp());
					w2.setWindDirection(w1.getWindDirection());
				}else{
					
				}
				
				for(;j<ws.size();i++){
					weathers.add(ws.get(j));
				}
				
			}
			
		}
		return weathers;
	}
	
	

}
