package com.kycoo.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.kycoo.domain.City;
import com.kycoo.domain.Weather;
import com.kycoo.service.CityService;
import com.kycoo.service.WeatherService;
import com.kycoo.utils.CommonUtil;
import com.kycoo.utils.WeatherUtil;
import com.kycoo.vo.TodayWeather;
import com.kycoo.vo.WeatherVO;

@Controller
public class WeatherController {
	
	@Autowired
	WeatherService weatherService;
	@Autowired
	CityService cityService;
	private WeatherVO weatherVO;
	
	@GetMapping(value="/searchWeather", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getTodayWeatherByCityName(String cityName,
			HttpServletRequest request,HttpServletResponse response){
		City city = null;
		if(cityName == null || cityName.length() == 0){
			boolean hasCityNameCookie = false;
			for ( Cookie c : request.getCookies()){
				if (c.getName().equals("cityName")) {
					cityName = c.getValue();
					city = cityService.getCityByName(cityName);
					hasCityNameCookie = true;
				}
			}
			if (!hasCityNameCookie) {
				String ip = getIpAddress(request);
				ip = "110.185.201.47";
				List<Weather> ipWeathers = WeatherUtil.listThisWeekWeatherByIp(ip);
				if (ipWeathers.size() > 0) {
					System.out.println("通过 ip 获取");
					city = ipWeathers.get(0).getCity();
					response.addCookie(new Cookie("cityName", city.getCityName()));
					response.addCookie(new Cookie("cityId", city.getId()));
				}
			}
		}else{
			city = cityService.getCityByName(cityName);
		}
		
		if(city != null){
			
			System.out.println(city.getCityName());
			TodayWeather w = new TodayWeather(weatherService.getTodayWeatherByCity(city));
			return JSON.toJSONString(w);
		}
		
		return "城市不唯一";
	}
	
	@GetMapping(value="/afterHalfMonth", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getAfterHalfMonthWeather(String cityName,HttpServletRequest request){
		
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getHeader("Cdn-Src-Ip"));
		System.out.println(getIpAddress(request));
		List<WeatherVO> weatherVOs = new ArrayList<>();
		System.out.println(cityName);
		City city = cityService.getCityByName(cityName);
		if(city != null){
			List<Weather> weathers = weatherService.getAfterHalfMonthWeather(city);
			for(Weather w:weathers){
				weatherVOs.add(new WeatherVO(w,true));
			}
			return JSON.toJSONString(weatherVOs);
		}
		return "";
	}
	
	@GetMapping(value="/24HoursWeather", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String get24HourWeather(String cityName){
		List<WeatherVO> weatherVOs = new ArrayList<>();
		City city = cityService.getCityByName(cityName);
		if(city != null){
			for(Weather w:weatherService.getAfter24HoursWeather(city)){
				weatherVOs.add(new WeatherVO(w,false));
			}
			return JSON.toJSONString(weatherVOs);
		}
		return "";
	}
	
	public static String getIpAddress(HttpServletRequest request) { 
	    String ip = request.getHeader("x-forwarded-for"); 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_CLIENT_IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getRemoteAddr(); 
	    } 
	    return ip; 
	  } 
}
