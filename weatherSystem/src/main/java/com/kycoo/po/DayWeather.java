package com.kycoo.po;

import java.io.Serializable;
import java.util.Date;

import com.kycoo.domain.Weather;
import com.kycoo.utils.CommonUtil;

public class DayWeather implements Serializable,GetWeatherAble {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getJiangshui() {
		return jiangshui;
	}
	public void setJiangshui(String jiangshui) {
		this.jiangshui = jiangshui;
	}
	public String getAir_press() {
		return air_press;
	}
	public void setAir_press(String air_press) {
		this.air_press = air_press;
	}
	public String getWeekday() {
		return weekday;
	}
	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}
	public String getNight_wind_direction() {
		return night_wind_direction;
	}
	public void setNight_wind_direction(String night_wind_direction) {
		this.night_wind_direction = night_wind_direction;
	}
	public Integer getNight_air_temperature() {
		return night_air_temperature;
	}
	public void setNight_air_temperature(Integer night_air_temperature) {
		this.night_air_temperature = night_air_temperature;
	}
	public String getNight_weather_pic() {
		return night_weather_pic;
	}
	public void setNight_weather_pic(String night_weather_pic) {
		this.night_weather_pic = night_weather_pic;
	}
	public String getNight_weather() {
		return night_weather;
	}
	public void setNight_weather(String night_weather) {
		this.night_weather = night_weather;
	}
	public String getNight_weather_code() {
		return night_weather_code;
	}
	public void setNight_weather_code(String night_weather_code) {
		this.night_weather_code = night_weather_code;
	}
	public String getDay_weather_code() {
		return day_weather_code;
	}
	public void setDay_weather_code(String day_weather_code) {
		this.day_weather_code = day_weather_code;
	}
	public String getZiwaixian() {
		return ziwaixian;
	}
	public void setZiwaixian(String ziwaixian) {
		this.ziwaixian = ziwaixian;
	}
	public String getDay_weather() {
		return day_weather;
	}
	public void setDay_weather(String day_weather) {
		this.day_weather = day_weather;
	}
	public String getDay_wind_power() {
		return day_wind_power;
	}
	public void setDay_wind_power(String day_wind_power) {
		this.day_wind_power = day_wind_power;
	}
	public String getDay_weather_pic() {
		return day_weather_pic;
	}
	public void setDay_weather_pic(String day_weather_pic) {
		this.day_weather_pic = day_weather_pic;
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
	public String getNight_wind_power() {
		return night_wind_power;
	}
	public void setNight_wind_power(String night_wind_power) {
		this.night_wind_power = night_wind_power;
	}
	public String getSun_begin_end() {
		return sun_begin_end;
	}
	public void setSun_begin_end(String sun_begin_end) {
		this.sun_begin_end = sun_begin_end;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	private String jiangshui; //��ˮ����
	private String air_press; //����ѹ
	private String weekday; //���ڼ�
	private String night_wind_direction; //ҹ�����
	private Integer night_air_temperature; //���������¶�(���϶�)
	private String night_weather_pic; //��������ͼƬ
	private String night_weather; //��������
	private String night_weather_code; //������������
	private String day_weather_code; //������������
	private String ziwaixian; //������
	private String day_weather; //��������
	private String day_wind_power; //�������
	private String day_weather_pic; //��������ͼƬ
	private Integer day_air_temperature; //�����¶�
	private String day_wind_direction; //�������
	private String night_wind_power; //ҹ�����
	private String sun_begin_end; //�ճ�����
	private String day; //����

	
	
	@Override
	public Weather getWeatherFormObj() {

		Weather weather = new Weather();
		weather.setDate(CommonUtil.convetString2Date(getDay()));
		weather.setHighTemp(day_air_temperature);
		weather.setLowTemp(night_air_temperature);
		//weather.setQuality(quality);
		weather.setWeather(day_weather);
		weather.setWindDirection(day_wind_direction);
		weather.setUpDateTime(CommonUtil.formatDate(new Date()));
		return weather;
	}
	
}