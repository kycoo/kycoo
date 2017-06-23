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
		Weather weather = weatherDao.getWeather(city, 
				CommonUtil.getTodayStartDate(),
				true,
				1).get(0);
//		//����24Сʱ�Զ�����
//		if (new Date().getTime() - weather.getDate().getTime() > 12*60*60*1000) {
//			Weather newWeather = WeatherUtil.
//		}
		return weather;
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
	 * ����api��ԭ��ֻ��ȡ��֮���23��Сʱ
	 */
	@Override
	public List<Weather> getAfter24HoursWeather(City city) {
		List<Weather> weathers = weatherDao.getWeather(city, 
				CommonUtil.formatDate(new Date()), 
				false, 23);
		//û���㹻������(��δ����)
		if (weathers.size() < 23) {
			List<Weather> ws = WeatherUtil.list24HourWeatherByArea(city.getCityName(), city.getId());
			Collections.sort(ws);
			Weather w1 = null,w2 = null;
			int j = 0,i = 0;
			for(;j<weathers.size()&&i<ws.size();i++){
				w1 = weathers.get(j++);
				w2 = ws.get(i);
				if(w2.getDate().before(w1.getDate())){
					j--;
					continue;
				}else if (w2.getDate().equals(w1.getDate())) {
					w2.setHighTemp(w1.getHighTemp());
					w2.setWeather(w1.getWeather());
					w2.setUpDateTime(w1.getUpDateTime());
					w2.setLowTemp(w1.getLowTemp());
					w2.setWindDirection(w1.getWindDirection());
				}else{
					
				}
			}
			for(;i<ws.size();i++){
				w2 = ws.get(i);
				weatherDao.save(w2);
				weathers.add(w2);
				
			}
			
		}
		return weathers;
	}
	
	

}
