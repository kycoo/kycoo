package com.kycoo.po;

import java.util.Date;

import com.kycoo.domain.Weather;
import com.kycoo.utils.CommonUtil;

public class HalfMonthWeather implements GetWeatherAble{

	 private String night_weather_code;
	 private String day_weather;
	 private String night_weather;
	 private String night_wind_power;
	 private String day_wind_power;
	 private String day_weather_code;
	 private String daytime;
	 private String day_weather_pic;
	 private Integer night_air_temperature;
	 private Integer day_air_temperature;
	 private String day_wind_direction;
	 private String night_weather_pic;
	 private String night_wind_direction;
	
	 
	
	
	
	public String getNight_weather_code() {
		return night_weather_code;
	}





	public void setNight_weather_code(String night_weather_code) {
		this.night_weather_code = night_weather_code;
	}





	public String getDay_weather() {
		return day_weather;
	}





	public void setDay_weather(String day_weather) {
		this.day_weather = day_weather;
	}





	public String getNight_weather() {
		return night_weather;
	}





	public void setNight_weather(String night_weather) {
		this.night_weather = night_weather;
	}





	public String getNight_wind_power() {
		return night_wind_power;
	}





	public void setNight_wind_power(String night_wind_power) {
		this.night_wind_power = night_wind_power;
	}





	public String getDay_wind_power() {
		return day_wind_power;
	}





	public void setDay_wind_power(String day_wind_power) {
		this.day_wind_power = day_wind_power;
	}





	public String getDay_weather_code() {
		return day_weather_code;
	}





	public void setDay_weather_code(String day_weather_code) {
		this.day_weather_code = day_weather_code;
	}





	public String getDaytime() {
		return daytime;
	}





	public void setDaytime(String daytime) {
		this.daytime = daytime;
	}





	public String getDay_weather_pic() {
		return day_weather_pic;
	}





	public void setDay_weather_pic(String day_weather_pic) {
		this.day_weather_pic = day_weather_pic;
	}





	public Integer getNight_air_temperature() {
		return night_air_temperature;
	}





	public void setNight_air_temperature(Integer night_air_temperature) {
		this.night_air_temperature = night_air_temperature;
	}





	public Integer getDay_air_temperature() {
		return day_air_temperature;
	}





	public void setDay_air_temperature(Integer day_air_temperature) {
		this.day_air_temperature = day_air_temperature;
	}





	public String getDay_wind_direction() {
		return day_wind_direction;
	}





	public void setDay_wind_direction(String day_wind_direction) {
		this.day_wind_direction = day_wind_direction;
	}





	public String getNight_weather_pic() {
		return night_weather_pic;
	}





	public void setNight_weather_pic(String night_weather_pic) {
		this.night_weather_pic = night_weather_pic;
	}





	public String getNight_wind_direction() {
		return night_wind_direction;
	}





	public void setNight_wind_direction(String night_wind_direction) {
		this.night_wind_direction = night_wind_direction;
	}





	@Override
	public Weather getWeatherFormObj() {
		Weather w = new Weather();
		w.setDate(CommonUtil.convetString2Date(daytime));
		w.setDay(true);
		Integer highTemp = day_air_temperature>night_air_temperature ?
				day_air_temperature:night_air_temperature;
		w.setHighTemp(highTemp);
		w.setLowTemp(highTemp == day_air_temperature ? 
				night_air_temperature:day_air_temperature);
		w.setWeather(day_weather);
		w.setWindDirection(day_wind_direction);
		w.setUpDateTime(CommonUtil.formatDate(new Date()));
		w.setImgUrl(day_weather_pic);
		return w;
	}

}
