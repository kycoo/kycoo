package com.kycoo.vo;

import org.hibernate.type.IntegerType;

import com.kycoo.domain.Weather;

public class DayWeatherVO {
	private String cityName;
	private String weather;
	private Integer highTemp;
	private Integer lowTemp;
	private String windDirection;
	private String imgUrl;
	
	public DayWeatherVO() {
		// TODO Auto-generated constructor stub
	}
	public DayWeatherVO(Weather w) {
		cityName = w.getCity().getCityName();
		weather = w.getWeather();
		highTemp = w.getHighTemp();
		lowTemp = w.getLowTemp();
		windDirection = w.getWindDirection();
		imgUrl = w.getImgUrl();
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
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
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
