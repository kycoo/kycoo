package com.kycoo.vo;


import com.kycoo.domain.Weather;
import com.kycoo.utils.CommonUtil;

public class WeatherVO {
	private String weather;
	private Integer highTemp;
	private Integer lowTemp;
	private String windDirection;
	private String date;
	public WeatherVO() {
	}
	public WeatherVO(Weather w,boolean isDay) {
		weather = w.getWeather();
		highTemp = w.getHighTemp();
		lowTemp = w.getLowTemp();
		windDirection = w.getWindDirection();
		
		date = isDay ? CommonUtil.getDay(w.getDate()) : CommonUtil.getHour(w.getDate());
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public Integer getHighTemp() {
		return highTemp;
	}
	public void setHighTemp(Integer highTemp) {
		this.highTemp = highTemp;
	}
	public Integer getLowTemp() {
		return lowTemp;
	}
	public void setLowTemp(Integer lowTemp) {
		this.lowTemp = lowTemp;
	}
	public String getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
