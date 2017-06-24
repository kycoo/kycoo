package com.kycoo.vo;

import com.kycoo.domain.Weather;

public class TodayWeather {
	private String weather;
	private Integer highTemp;
	private Integer lowTemp;
	private String windDirection;
	private String img;
	private String lifeRate;
	private String cityName;
	
	public TodayWeather() {
		// TODO Auto-generated constructor stub
	}
	
	public TodayWeather(Weather w){
		weather = w.getWeather();
		highTemp = w.getHighTemp();
		lowTemp = w.getLowTemp();
		windDirection = w.getWindDirection();
		img = w.getImgUrl();
		lifeRate = "се";
		cityName = w.getCity().getCityName();
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLifeRate() {
		return lifeRate;
	}

	public void setLifeRate(String lifeRate) {
		this.lifeRate = lifeRate;
	}
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	
}
