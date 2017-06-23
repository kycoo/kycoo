package com.kycoo.po;

import java.util.Date;

import com.kycoo.domain.Weather;
import com.kycoo.utils.CommonUtil;

public class HourWeather implements GetWeatherAble{
	private String weather_code;
    private String time;
    private String wind_direction;
    private String wind_power;
    private String weather;
    private Integer temperature;
    
	
	public String getWeather_code() {
		return weather_code;
	}
	public void setWeather_code(String weather_code) {
		this.weather_code = weather_code;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getWind_direction() {
		return wind_direction;
	}
	public void setWind_direction(String wind_direction) {
		this.wind_direction = wind_direction;
	}
	public String getWind_power() {
		return wind_power;
	}
	public void setWind_power(String wind_power) {
		this.wind_power = wind_power;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public Integer getTemperature() {
		return temperature;
	}
	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}
	
	
	@Override
	public Weather getWeatherFormObj() {
		Weather w = new Weather();
		w.setDate(CommonUtil.formatDate(
				CommonUtil.convetString2Date(time)));
		w.setHighTemp(temperature);
		w.setWeather(weather);
		w.setWindDirection(wind_direction);
		w.setUpDateTime(new Date());
		return w;
	}
	
    
}
